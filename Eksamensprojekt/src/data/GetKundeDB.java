package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Kunde;
import domain.Kundelmpl;
import exceptions.TelefonnummerIkkeOplystException;

public class GetKundeDB {


	public List<Kunde> findKunde(Kunde kunde) throws Exception {
		List<Kunde> kundeliste = new ArrayList<>();
		try (DataAccess access = new DataAccess()) {
			try {
				findKunde(access, kundeliste, kunde);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return kundeliste;
	}

	public void findKunde(DataAccess access, List<Kunde> kundeliste, Kunde kunde) throws TelefonnummerIkkeOplystException {
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("SELECT * FROM KUNDE where telefonnummer = ?;");) {

			statement.setString(1, kunde.getTelefonNummer());

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Kunde findkunde = new Kundelmpl();
				findkunde.setForNavn(rs.getString("FORNAVN"));
				findkunde.setEfterNavn(rs.getString("EFTERNAVN")); 
				findkunde.setAdresse(rs.getString("ADRESSE"));
				findkunde.setPostNummer(rs.getString("POSTNUMMER"));
				findkunde.setBy(rs.getString("BYEN"));
				findkunde.setFodselsdato(rs.getString("FODSELSDATO"));
				findkunde.setTelefonNummer(rs.getString("TELEFONNUMMER"));
				findkunde.setEmail(rs.getString("EMAIL"));

				kundeliste.add(findkunde);
			}
		} catch (SQLException e) {
			throw new RuntimeException("fejl ved søgning", e);
		}
	}
}