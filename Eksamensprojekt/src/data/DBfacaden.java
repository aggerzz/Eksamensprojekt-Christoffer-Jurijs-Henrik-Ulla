package data;

import data.OpretKundeDB;
import domain.Bil;
import domain.Kunde;
import domain.Sælger;

public class DBfacaden {

	private OpretKundeDB opretKundeInfo = new OpretKundeDB();

	public void opretKundeInfo(Kunde kunde) { 
		opretKundeInfo.opretKunde(kunde);
	}
	
	private OpretSælgerDB opretSælgerInfo = new OpretSælgerDB();

	public void opretSælgerInfo(Sælger sælger) { 
		opretSælgerInfo.opretSælger(sælger);
	}
	
	private OpretBilDB opretBilInfo = new OpretBilDB();

	public void opretBilInfo(Bil bil) { 
		opretBilInfo.opretBil(bil);
	}

}
