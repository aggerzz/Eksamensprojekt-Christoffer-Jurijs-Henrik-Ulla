package logic;

import data.DBfacaden;
import domain.Kunde;

public class FFLogic {

	// Opret Kunde
	private DBfacaden opretKundeInfo = new DBfacaden();

	public void opretKunde(Kunde kunde) {
		opretKundeInfo.opretKundeInfo(kunde);
	}
}
