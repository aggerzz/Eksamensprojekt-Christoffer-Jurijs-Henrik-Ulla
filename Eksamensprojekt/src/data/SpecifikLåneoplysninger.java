package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Låneanmodning;

public class SpecifikLåneoplysninger {

	public double Rentesats;
	public double PrisEfterRente;
	public double MånedligYdelse;
	public int løbetid;
	public double udbetaling;
	
	public void findSpecifikLån(Låneanmodning låneanmodning) throws Exception {
		try (DataAccess access = new DataAccess()) {
			try {
				findSpecifikLån(access, låneanmodning);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
	}

	private void findSpecifikLån(DataAccess access, Låneanmodning låneanmodning) throws Exception {
		
		try (PreparedStatement statement = access.getConnection()
				.prepareStatement("SELECT * FROM Låneanmodning WHERE  telefonnummer = ?");) {
			statement.setString(1, låneanmodning.getTelefonNummer());

			ResultSet rs = statement.executeQuery();

			if (rs.next())
				Rentesats = rs.getDouble("rentesats");
			PrisEfterRente = rs.getDouble("PrisEfterRente");
			MånedligYdelse = rs.getDouble("MånedligYdelse");
					løbetid = rs.getInt("løbetid");
					udbetaling = rs.getDouble("udbetaling");
					
			låneanmodning.setRentesats(Rentesats);
			låneanmodning.setPrisEfterRente(PrisEfterRente);
			låneanmodning.setMånedligYdelse(MånedligYdelse);
			låneanmodning.setLøbetid(løbetid);
			låneanmodning.setUdbetaling(udbetaling);
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
