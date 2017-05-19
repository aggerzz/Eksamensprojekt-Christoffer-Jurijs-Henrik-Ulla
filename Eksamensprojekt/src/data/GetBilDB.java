package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.DataAccess;
import domain.Bil;
import exceptions.ModelIkkeOplystException;
import exceptions.PrisIkkeOplystException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.ÅrgangIkkeOplystException;

public class GetBilDB {
	public int bilensPris;

	public void getBil(Bil bil) throws ModelIkkeOplystException, StelnummerIkkeOplystException,
			ÅrgangIkkeOplystException, PrisIkkeOplystException {
		try (DataAccess access = new DataAccess()) {
			try {
				getBil(access, bil);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
	}

	private void getBil(DataAccess access, Bil bil) throws ModelIkkeOplystException,
			StelnummerIkkeOplystException, ÅrgangIkkeOplystException, PrisIkkeOplystException {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("SELECT pris FROM BIL WHERE  STELNUMMER  LIKE '?'");) {

			ResultSet rs = statement.executeQuery();

			String bilensPris = rs.getString(4);
			System.out.println(bilensPris);

//			System.out.println("Antal rækker berørt : ");
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
