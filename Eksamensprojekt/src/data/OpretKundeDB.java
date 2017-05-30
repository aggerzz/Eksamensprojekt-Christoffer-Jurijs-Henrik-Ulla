package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.DataAccess;
import domain.Kunde;
import exceptions.AdresseIkkeOplystException;
import exceptions.ByIkkeOplystException;
import exceptions.EfternavnIkkeOplystException;
import exceptions.EmailIkkeOplystException;
import exceptions.FodselsdagIkkeOplystException;
import exceptions.FornavnIkkeOplystException;
import exceptions.PostnummerIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;

public class OpretKundeDB {
	public void opretKunde(Kunde kunde) throws AdresseIkkeOplystException, ByIkkeOplystException,
			EfternavnIkkeOplystException, EmailIkkeOplystException, FodselsdagIkkeOplystException,
			FornavnIkkeOplystException, PostnummerIkkeOplystException, TelefonnummerIkkeOplystException {
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

	private void opretKunde(DataAccess access, Kunde kunde) throws AdresseIkkeOplystException, ByIkkeOplystException,
			EfternavnIkkeOplystException, EmailIkkeOplystException, FodselsdagIkkeOplystException,
			FornavnIkkeOplystException, PostnummerIkkeOplystException, TelefonnummerIkkeOplystException {
		try (PreparedStatement statement = access.getConnection().prepareStatement(
				"INSERT INTO KUNDE (FORNAVN, EFTERNAVN, ADRESSE, BYEN, POSTNUMMER, FODSELSDATO, TELEFONNUMMER, EMAIL ) VALUES ( ?, ?, ?,? , ?, ?, ?, ?)");) {
			statement.setString(1, kunde.getForNavn());
			statement.setString(2, kunde.getEfterNavn());
			statement.setString(3, kunde.getAdresse());
			statement.setString(4, kunde.getBy());
			statement.setString(5, kunde.getPostNummer());
			statement.setString(6, kunde.getFodselsdato());
			statement.setString(7, kunde.getTelefonNummer());
			statement.setString(8, kunde.getEmail());
			int antal = statement.executeUpdate();
			System.out.println("Antal rækker berørt : " + antal);
		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);
		}
	}
}
