package data;

import data.OpretKundeDB;
import domain.Bil;
import domain.Kunde;
import domain.Sælger;
import exceptions.MangledeInformationOmSælgerException;
import exceptions.AdresseIkkeOplystException;
import exceptions.ByIkkeOplystException;
import exceptions.EfternavnIkkeOplystException;
import exceptions.EmailIkkeOplystException;
import exceptions.FodselsdagIkkeOplystException;
import exceptions.FornavnIkkeOplystException;
import exceptions.PostnummerIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;
import exceptions.ModelIkkeOplystException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.ÅrgangIkkeOplystException;

public class DBfacaden {

	private OpretKundeDB opretKundeInfo = new OpretKundeDB();

	public void opretKundeInfo(Kunde kunde) throws AdresseIkkeOplystException, ByIkkeOplystException,
			EfternavnIkkeOplystException, EmailIkkeOplystException, FodselsdagIkkeOplystException,
			FornavnIkkeOplystException, PostnummerIkkeOplystException, TelefonnummerIkkeOplystException {
		opretKundeInfo.opretKunde(kunde);
	}

	private OpretSælgerDB opretSælgerInfo = new OpretSælgerDB();

	public void opretSælgerInfo(Sælger sælger) throws MangledeInformationOmSælgerException {
		opretSælgerInfo.opretSælger(sælger);
	}

	private OpretBilDB opretBilInfo = new OpretBilDB();

	public void opretBilInfo(Bil bil)
			throws ModelIkkeOplystException, StelnummerIkkeOplystException, ÅrgangIkkeOplystException {
		opretBilInfo.opretBil(bil);
	}

}
