package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.DataAccess;
import domain.Bil;
import exceptions.ModelIkkeOplystException;
import exceptions.PrisIkkeOplystException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.ÅrgangIkkeOplystException;

public class OpretBilDB {
	public void opretBil(Bil bil) throws ModelIkkeOplystException, StelnummerIkkeOplystException,
			ÅrgangIkkeOplystException, PrisIkkeOplystException {
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

	private void opretBil(DataAccess access, Bil bil) throws ModelIkkeOplystException, StelnummerIkkeOplystException,
			ÅrgangIkkeOplystException, PrisIkkeOplystException {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("INSERT INTO BIL (MODEL, STELNUMMER, ÅRGANG, PRIS) VALUES ( ?, ?, ?,?)");) {
			statement.setString(1, bil.getModel());
			statement.setString(2, bil.getStelNummer());
			statement.setString(3, bil.getÅrgang());
			statement.setString(4, bil.getPris());

			int antal = statement.executeUpdate();
			System.out.println("Antal rækker berørt : " + antal);
		} catch (SQLException e) {
			throw new RuntimeException("Fejl ved oprettelse", e);
		}
	}
}
