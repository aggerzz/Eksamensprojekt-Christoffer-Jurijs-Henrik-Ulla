package logic;

import data.DBfacaden;
import domain.Bil;
import domain.Kunde;
import domain.Sælger;

public class FFLogic {

	// Opret Kunde
	private DBfacaden opretKundeInfo = new DBfacaden();

	public void opretKunde(Kunde kunde) {
		opretKundeInfo.opretKundeInfo(kunde);
	}
	// Opret Sælger
	private DBfacaden opretSælgerInfo = new DBfacaden();

	public void opretSælger(Sælger sælger) {
		opretSælgerInfo.opretSælgerInfo(sælger);
	}
	// Opret Bil
	private DBfacaden opretBilInfo = new DBfacaden();

	public void opretBil(Bil bil) {
		opretBilInfo.opretBilInfo(bil);
	}
}
