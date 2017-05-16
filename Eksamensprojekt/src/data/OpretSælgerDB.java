package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.DataAccess;
import domain.Sælger;
import exceptions.AdgangskodeIkkeOplystException;
import exceptions.BrugernavnIkkeOplystException;
import exceptions.EfternavnIkkeOplystException;
import exceptions.EmailIkkeOplystException;
import exceptions.FornavnIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;

public class OpretSælgerDB {
	public void opretSælger(Sælger sælger) throws FornavnIkkeOplystException, EfternavnIkkeOplystException, TelefonnummerIkkeOplystException,
	EmailIkkeOplystException, BrugernavnIkkeOplystException, AdgangskodeIkkeOplystException {
		try (DataAccess access = new DataAccess()) {
			try {
				opretSælger(access, sælger);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
	}

	private void opretSælger(DataAccess access, Sælger sælger) throws FornavnIkkeOplystException, EfternavnIkkeOplystException, TelefonnummerIkkeOplystException,
	EmailIkkeOplystException, BrugernavnIkkeOplystException, AdgangskodeIkkeOplystException {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("INSERT INTO SÆLGER (LOGIN, ADGANGSKODE, FORNAVN, EFTERNAVN, TELEFONNUMMER, EMAIL) VALUES ( ?, ?, ?,? , ?, ?)");) {
			statement.setString(1, sælger.getLogin());
			statement.setString(2, sælger.getAdgangskode());
			statement.setString(3, sælger.getForNavn());
			statement.setString(4, sælger.getEfterNavn());
			statement.setString(5, sælger.getTelefonNummer());
			statement.setString(6, sælger.getEmail());

			int antal = statement.executeUpdate();
			System.out.println("Antal rækker berørt : " + antal);
		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);
		}
	}
}
