package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Bil;
import domain.Billmpl;
import domain.Låneanmodning;
import domain.Låneanmodninglmpl;
import exceptions.StelnummerIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;

public class LåneInfoDB {
	public List<Låneanmodning> findLån(Låneanmodning låneanmodning) throws Exception {
		List<Låneanmodning> lånliste = new ArrayList<>();
		try (DataAccess access = new DataAccess()) {
			try {
				findLån(access, lånliste, låneanmodning);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return lånliste;
	}

	public void findLån(DataAccess access, List<Låneanmodning> lånliste, Låneanmodning låneanmodning)
			throws TelefonnummerIkkeOplystException, StelnummerIkkeOplystException {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("SELECT * FROM LÅNEANMODNING where telefonnummer = ?;");) {

			statement.setString(1, låneanmodning.getTelefonNummer());

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Låneanmodning findlån = new Låneanmodninglmpl();
				findlån.setSælgerID(rs.getInt("SælgerID"));
				findlån.setPersonNummer(rs.getString("PERSONNUMMER"));
				findlån.setTelefonNummer(rs.getString("TELEFONNUMMER"));
				findlån.setKreditværdighed(rs.getString("KREDITVÆRDIGHED").charAt(0));
				findlån.setRentesats(rs.getDouble("RENTESATS"));
				findlån.setMånedligYdelse(rs.getDouble("MÅNEDLIGYDELSE"));
				findlån.setPrisEfterRente(rs.getDouble("PRISEFTERRENTE"));
				findlån.setStelNummer(rs.getString("STELNUMMER"));
				findlån.setPris(rs.getDouble("PRIS"));
				findlån.setLøbetid(rs.getInt("LØBETID"));
				findlån.setUdbetaling(rs.getDouble("UDBETALING"));

				lånliste.add(findlån);
			}
		} catch (SQLException e) {
			throw new RuntimeException("fejl ved søgning", e);
		}
	}
}
