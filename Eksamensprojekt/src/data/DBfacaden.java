package data;

import data.OpretKundeDB;
import domain.Billmpl;
import domain.Kunde;
import domain.Kundelmpl;
import domain.Sælgerlmpl;
import exceptions.MangledeInformationOmKundenException;

public class DBfacaden {

	private OpretKundeDB opretKundeInfo = new OpretKundeDB();

	public void opretKundeInfo(Kunde kunde) throws MangledeInformationOmKundenException { 
		opretKundeInfo.opretKunde(kunde);
	}
	
	private OpretSælgerDB opretSælgerInfo = new OpretSælgerDB();

	public void opretSælgerInfo(Sælgerlmpl sælger) throws Exception { 
		opretSælgerInfo.opretSælger(sælger);
	}
	
	private OpretBilDB opretBilInfo = new OpretBilDB();

	public void opretBilInfo(Billmpl bil) throws Exception { 
		opretBilInfo.opretBil(bil);
	}

}
