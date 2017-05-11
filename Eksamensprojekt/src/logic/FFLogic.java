package logic;

import data.DBfacaden;
import domain.Bil;
import domain.Billmpl;
import domain.Kunde;
import domain.Kundelmpl;
import domain.Sælger;
import domain.Sælgerlmpl;
import exceptions.MangledeInformationOmBilenException;
import exceptions.MangledeInformationOmKundenException;
import exceptions.MangledeInformationOmSælgerException;

public class FFLogic {

	// Opret Kunde
	private DBfacaden opretKundeInfo = new DBfacaden();

	public void opretKunde(Kunde kunde) throws MangledeInformationOmKundenException {
		opretKundeInfo.opretKundeInfo(kunde);
	}
	// Opret Sælger
	private DBfacaden opretSælgerInfo = new DBfacaden();

	public void opretSælger(Sælger sælger) throws MangledeInformationOmSælgerException {
		opretSælgerInfo.opretSælgerInfo(sælger);
	}
	// Opret Bil
	private DBfacaden opretBilInfo = new DBfacaden();

	public void opretBil(Bil bil) throws MangledeInformationOmBilenException {
		opretBilInfo.opretBilInfo(bil);
	}
}
