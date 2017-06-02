package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Bil;
import domain.Billmpl;
import exceptions.StelnummerIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;

public class GetBilerDB {

	public List<Bil> findBiler(Bil bil) throws Exception {
		List<Bil> billiste = new ArrayList<>();
		try (DataAccess access = new DataAccess()) {
			try {
				findBiler(access, billiste, bil);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return billiste;
	}

	public void findBiler(DataAccess access, List<Bil> billiste, Bil bil)
			throws TelefonnummerIkkeOplystException, StelnummerIkkeOplystException {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("SELECT * FROM BIL where stelnummer = ?;");) {

			statement.setString(1, bil.getStelNummer());

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Bil findbiler = new Billmpl();
				findbiler.setModel(rs.getString("MODEL"));
				findbiler.setStelNummer(rs.getString("STELNUMMER"));
				findbiler.setÅrgang(rs.getString("ÅRGANG"));
				findbiler.setPris(rs.getString("PRIS"));

				billiste.add(findbiler);
			}
		} catch (SQLException e) {
			throw new RuntimeException("fejl ved søgning", e);
		}
	}
}