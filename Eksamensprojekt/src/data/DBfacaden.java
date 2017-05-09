package data;

import data.OpretKundeDB;
import domain.Kunde;

public class DBfacaden {

	private OpretKundeDB opretKundeInfo = new OpretKundeDB();

	public void createMatchInfo(Kunde kunde) {
		opretKundeInfo.opretKunde(kunde);
	}

}
