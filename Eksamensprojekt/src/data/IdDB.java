package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Sælger;
import exceptions.AdgangskodeIkkeOplystException;
import exceptions.BrugernavnIkkeOplystException;
import exceptions.ModelIkkeOplystException;
import exceptions.PrisIkkeOplystException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.ÅrgangIkkeOplystException;

public class IdDB {
	public int id;

	public void CheckID(Sælger sælger) throws Exception {
		try (DataAccess access = new DataAccess()) {
			try {
				CheckID(access, sælger);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
	}

	private void CheckID(DataAccess access, Sælger sælger)
			throws ModelIkkeOplystException, StelnummerIkkeOplystException, ÅrgangIkkeOplystException,
			PrisIkkeOplystException, BrugernavnIkkeOplystException, AdgangskodeIkkeOplystException {
		// System.out.println(bil.getStelNummer());
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("select id from sælger where login=? and adgangskode=?");) {
			statement.setString(1, sælger.getLogin());
			statement.setString(2, sælger.getAdgangskode());
			ResultSet rs = statement.executeQuery();

			if (rs.next())
				id = rs.getInt("Id");
			System.out.println(id);
			sælger.setId(id);
			// System.out.println("Antal rækker berørt : "); ATT; Morten Vi vil
			// her gerne have pris på bilen ud af databasen
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
