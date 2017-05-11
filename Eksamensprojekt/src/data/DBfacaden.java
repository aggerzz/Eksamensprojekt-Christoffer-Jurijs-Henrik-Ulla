package data;

import data.OpretKundeDB;
import domain.Bil;
import domain.Billmpl;
import domain.Kunde;
import domain.Kundelmpl;
import domain.Sælger;
import domain.Sælgerlmpl;
import exceptions.MangledeInformationOmBilenException;
import exceptions.MangledeInformationOmKundenException;
import exceptions.MangledeInformationOmSælgerException;

public class DBfacaden {

	private OpretKundeDB opretKundeInfo = new OpretKundeDB();

	public void opretKundeInfo(Kunde kunde) throws MangledeInformationOmKundenException { 
		opretKundeInfo.opretKunde(kunde);
	}
	
	private OpretSælgerDB opretSælgerInfo = new OpretSælgerDB();

	public void opretSælgerInfo(Sælger sælger) throws MangledeInformationOmSælgerException { 
		opretSælgerInfo.opretSælger(sælger);
	}
	
	private OpretBilDB opretBilInfo = new OpretBilDB();

	public void opretBilInfo(Bil bil) throws MangledeInformationOmBilenException { 
		opretBilInfo.opretBil(bil);
	}

}
