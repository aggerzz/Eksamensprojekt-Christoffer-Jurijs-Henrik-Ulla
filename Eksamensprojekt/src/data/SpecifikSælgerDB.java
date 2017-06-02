package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import domain.Sælger;

public class SpecifikSælgerDB {
	public int SælgerID;
	public String SælgerForNavn;
	public String SælgerEfterNavn;
	
	
	
	public void findSpecifikSælger(Sælger sælger) throws Exception {
		try (DataAccess access = new DataAccess()) {
			try {
				findSpecifikSælger(access, sælger);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
	}

	private void findSpecifikSælger(DataAccess access, Sælger sælger) throws Exception {
		
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("SELECT * FROM SÆLGER WHERE  id = ?");) {
			statement.setInt(1, sælger.getId());

			ResultSet rs = statement.executeQuery();

			if (rs.next())
				SælgerID = rs.getInt("ID");
			SælgerForNavn = rs.getString("Fornavn");
			SælgerEfterNavn = rs.getString("Efternavn");
					
			sælger.setId(SælgerID);
			sælger.setForNavn(SælgerForNavn);
			sælger.setEfterNavn(SælgerEfterNavn);
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
