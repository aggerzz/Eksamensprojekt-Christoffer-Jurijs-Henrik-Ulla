package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.DataAccess;
import domain.Kunde;

public class OpretKundeDB {
	public void opretKunde(Kunde kunde) {
		try (DataAccess access = new DataAccess()) {
			try {
				opretKunde(access, kunde);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
	}

	private void opretKunde(DataAccess access, Kunde kunde) {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("INSERT INTO KUNDE (FORNAVN, EFTERNAVN, ADRESSE ) VALUES (asd ,sad ,dsa)");) {
			statement.setString(1, kunde.getForNavn());
			statement.setString(2, kunde.getEfterNavn());
			statement.setString(3, kunde.getAdresse());
			int antal = statement.executeUpdate();
			System.out.println("Antal rækker berørt : " + antal);
		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);
		}
	}
}
