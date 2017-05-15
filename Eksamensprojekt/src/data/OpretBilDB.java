package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.DataAccess;
import domain.Bil;
import exceptions.ModelIkkeOplystException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.ÅrgangIkkeOplystException;

public class OpretBilDB {
	public void opretBil(Bil bil)
			throws ModelIkkeOplystException, StelnummerIkkeOplystException, ÅrgangIkkeOplystException {
		try (DataAccess access = new DataAccess()) {
			try {
				opretBil(access, bil);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
	}

	private void opretBil(DataAccess access, Bil bil)
			throws ModelIkkeOplystException, StelnummerIkkeOplystException, ÅrgangIkkeOplystException {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("INSERT INTO BIL (MODEL, STELNUMMER, ÅRGANG) VALUES ( ?, ?, ?)");) {
			statement.setString(1, bil.getModel());
			statement.setString(2, bil.getStelNummer());
			statement.setString(3, bil.getÅrgang());

			int antal = statement.executeUpdate();
			System.out.println("Antal rækker berørt : " + antal);
		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);
		}
	}
}
