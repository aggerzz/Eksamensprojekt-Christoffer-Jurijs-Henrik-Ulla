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
	
	public String bilensPris;

	public void findBil(Bil bil) throws ModelIkkeOplystException, StelnummerIkkeOplystException,
			ÅrgangIkkeOplystException, PrisIkkeOplystException {
				try (DataAccess access = new DataAccess()) {
			try {
				findBil(access, bil);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
	}

	private void findBil(DataAccess access, Bil bil) throws ModelIkkeOplystException,
			StelnummerIkkeOplystException, ÅrgangIkkeOplystException, PrisIkkeOplystException {
		System.out.println(bil.getStelNummer());
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("SELECT pris FROM BIL WHERE  STELNUMMER = ?");) {
			statement.setString(1, bil.getStelNummer());
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
				bilensPris = rs.getString("Pris");
			
			bil.setPris(bilensPris);
//			System.out.println("Antal rækker berørt : "); ATT; Morten Vi vil her gerne have pris på bilen ud af databasen
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
