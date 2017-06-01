package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Bil;
import domain.Billmpl;
import domain.Sælger;
import domain.Sælgerlmpl;
import exceptions.BrugernavnIkkeOplystException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;

public class SælgerInfoDB {
	public List<Sælger> findSælger(Sælger sælger) throws Exception {
		List<Sælger> sælgerinfo = new ArrayList<>();
		try (DataAccess access = new DataAccess()) {
			try {
				findSælger(access, sælgerinfo, sælger);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return sælgerinfo;
	}

	public void findSælger(DataAccess access, List<Sælger> sælgerinfo, Sælger sælger) throws TelefonnummerIkkeOplystException, StelnummerIkkeOplystException, BrugernavnIkkeOplystException {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("SELECT * FROM BIL where stelnummer = ?;");) {

			statement.setString(1, sælger.getLogin());

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Sælger findsælger = new Sælgerlmpl();
				findsælger.setForNavn(rs.getString("FORNAVN"));
				findsælger.setEfterNavn(rs.getString("EFTERNAVN")); 
				findsælger.setTelefonNummer(rs.getString("TELEFONNUMMER"));
				findsælger.setEmail(rs.getString("EMAIL"));


				sælgerinfo.add(findsælger);
			}
		} catch (SQLException e) {
			throw new RuntimeException("fejl ved søgning", e);
		}
	}
}

