package logic;

import data.DBfacaden;
import domain.Billmpl;
import domain.Kundelmpl;
import domain.Sælgerlmpl;

public class FFLogic {

	// Opret Kunde
	private DBfacaden opretKundeInfo = new DBfacaden();

	public void opretKunde(Kundelmpl kunde) {
		opretKundeInfo.opretKundeInfo(kunde);
	}
	// Opret Sælger
	private DBfacaden opretSælgerInfo = new DBfacaden();

	public void opretSælger(Sælgerlmpl sælger) {
		opretSælgerInfo.opretSælgerInfo(sælger);
	}
	// Opret Bil
	private DBfacaden opretBilInfo = new DBfacaden();

	public void opretBil(Billmpl bil) {
		opretBilInfo.opretBilInfo(bil);
	}
}
