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
				.prepareStatement("INSERT INTO KUNDE (FORNAVN, EFTERNAVN, ADRESSE, POSTNUMMER, BYEN, FODSELSDATO, TELEFONNUMMER, EMAIL ) VALUES ( ?, ?, ?,? , ?, ?, ?, ?)");) {
			statement.setString(1, kunde.getForNavn());
			statement.setString(2, kunde.getEfterNavn());
			statement.setString(3, kunde.getAdresse());
			statement.setString(4, kunde.getBy());
			statement.setInt(5, kunde.getPostNummer());
			statement.setString(6, kunde.getFodselsdato());
			statement.setInt(7, kunde.getTelefonNummer());
			statement.setString(8, kunde.getEmail());
			int antal = statement.executeUpdate();
			System.out.println("Antal rækker berørt : " + antal);
		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);
		}
	}
}
