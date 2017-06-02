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
	public void opretLåneanmodning(Låneanmodning låneanmodning) throws Exception {
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

	private void opretLåneanmodning(DataAccess access, Låneanmodning låneanmodning) throws Exception {
		try (PreparedStatement statement = access.getConnection().prepareStatement(
				"INSERT INTO LÅNEANMODNING (SÆLGERID, PERSONNUMMER, TELEFONNUMMER, KREDITVÆRDIGHED,RENTESATS, MÅNEDLIGYDELSE, PRISEFTERRENTE, STELNUMMER,PRIS, LØBETID, UDBETALING) VALUES ( ?, ?, ?,?,?,?,?,?,?,?,?)");) {
			statement.setInt(1, låneanmodning.getSælgerID());
			statement.setString(2, låneanmodning.getPersonNummer());
			statement.setString(3, låneanmodning.getTelefonNummer());
			statement.setString(4, String.valueOf(låneanmodning.getKreditværdighed()));
			statement.setDouble(5, låneanmodning.getRentesats());
			statement.setDouble(6, låneanmodning.getMånedligYdelse());
			statement.setDouble(7, låneanmodning.getPrisEfterRente());
			statement.setString(8, låneanmodning.getStelNummer());
			statement.setDouble(9, låneanmodning.getPris());
			statement.setInt(10, låneanmodning.getLøbetid());
			statement.setDouble(11, låneanmodning.getUdbetaling());

			int antal = statement.executeUpdate();
			System.out.println("Antal rækker berørt : " + antal);
		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);
		}
	}
}
