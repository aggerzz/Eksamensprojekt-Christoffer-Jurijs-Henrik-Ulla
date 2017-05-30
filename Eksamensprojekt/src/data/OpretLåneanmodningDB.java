package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.DataAccess;
import domain.Låneanmodning;
import exceptions.KreditværdighedIkkeUdfyldtException;
import exceptions.LøbetidIkkeUdfyldtException;
import exceptions.PersonnummerIkkeUdfyldtException;
import exceptions.RentesatsIkkeUdfyldtException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;

public class OpretLåneanmodningDB {
	public void opretLåneanmodning(Låneanmodning låneanmodning)
			throws StelnummerIkkeOplystException, KreditværdighedIkkeUdfyldtException, PersonnummerIkkeUdfyldtException,
			TelefonnummerIkkeOplystException, RentesatsIkkeUdfyldtException, LøbetidIkkeUdfyldtException {
		try (DataAccess access = new DataAccess()) {
			try {
				opretLåneanmodning(access, låneanmodning);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
	}

	private void opretLåneanmodning(DataAccess access, Låneanmodning låneanmodning)
			throws StelnummerIkkeOplystException, KreditværdighedIkkeUdfyldtException, PersonnummerIkkeUdfyldtException,
			TelefonnummerIkkeOplystException, RentesatsIkkeUdfyldtException, LøbetidIkkeUdfyldtException {
		try (PreparedStatement statement = access.getConnection().prepareStatement(
				"INSERT INTO LÅNEANMODNING (PERSONNUMMER, TELEFONNUMMER, KREDITVÆRDIGHED, RENTESATS, STELNUMMER, LØBETID, UDBETALING) VALUES ( ?, ?, ?,?,?,?,?)");) {
			statement.setString(1, låneanmodning.getPersonNummer());
			statement.setString(2, låneanmodning.getTelefonNummer());
			statement.setString(3, String.valueOf(låneanmodning.getKreditværdighed()));
			statement.setDouble(4, låneanmodning.getRentesats());
			statement.setString(5, låneanmodning.getStelNummer());
			statement.setInt(6, låneanmodning.getLøbetid());
			statement.setDouble(7, låneanmodning.getUdbetaling());

			int antal = statement.executeUpdate();
			System.out.println("Antal rækker berørt : " + antal);
		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);
		}
	}
}
