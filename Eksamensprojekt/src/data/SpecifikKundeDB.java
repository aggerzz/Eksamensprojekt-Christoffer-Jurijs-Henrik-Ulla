package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Bil;
import domain.Kunde;
import domain.Kundelmpl;
import exceptions.ModelIkkeOplystException;
import exceptions.PrisIkkeOplystException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;
import exceptions.ÅrgangIkkeOplystException;

public class SpecifikKundeDB {
	public String Fornavn;
	public String Efternavn;
	public String Telefonnummer;
	public void findSpecifikKunde(Kunde kunde) throws Exception {
try (DataAccess access = new DataAccess()) {
	try {
		findSpecifikKunde(access, kunde);
		access.commit();
	} catch (Exception e) {
		access.rollback();
		throw e;
	}
}
}

private void findSpecifikKunde(DataAccess access, Kunde kunde) throws Exception {
System.out.println(kunde.getTelefonNummer());
try (PreparedStatement statement = access.getConnection()
		.prepareStatement("SELECT * FROM kunde WHERE  telefonnummer = ?");) {
	statement.setString(1, kunde.getTelefonNummer());

	ResultSet rs = statement.executeQuery();

	if (rs.next())
		Fornavn = rs.getString("fornavn");
		Efternavn = rs.getString("Efternavn");
		Telefonnummer = rs.getString("Telefonnummer");

	kunde.setForNavn(Fornavn);
	kunde.setEfterNavn(Efternavn);
	kunde.setTelefonNummer(Telefonnummer);
	
} catch (SQLException e) {
	throw new RuntimeException();
}
}
}
