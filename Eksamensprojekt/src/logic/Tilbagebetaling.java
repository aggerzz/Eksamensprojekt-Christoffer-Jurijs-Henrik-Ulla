package logic;

import data.DBfacaden;
import domain.Låneanmodning;

public class Tilbagebetaling {
	// Tilbagebetaling
	private DBfacaden findlånInfo = new DBfacaden();
	public void findLån(Låneanmodning låneanmodning) throws Exception {
		findlånInfo.findLån(låneanmodning);
	}
	
}
