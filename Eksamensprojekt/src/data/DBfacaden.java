package data;

import data.OpretKundeDB;
import domain.Billmpl;
import domain.Kundelmpl;
import domain.Sælgerlmpl;

public class DBfacaden {

	private OpretKundeDB opretKundeInfo = new OpretKundeDB();

	public void opretKundeInfo(Kundelmpl kunde) { 
		opretKundeInfo.opretKunde(kunde);
	}
	
	private OpretSælgerDB opretSælgerInfo = new OpretSælgerDB();

	public void opretSælgerInfo(Sælgerlmpl sælger) { 
		opretSælgerInfo.opretSælger(sælger);
	}
	
	private OpretBilDB opretBilInfo = new OpretBilDB();

	public void opretBilInfo(Billmpl bil) { 
		opretBilInfo.opretBil(bil);
	}

}
