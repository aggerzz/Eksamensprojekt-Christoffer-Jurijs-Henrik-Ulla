package logic;

import data.DBfacaden;
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

public class FFLogic {

	// Opret Kunde
	private DBfacaden opretKundeInfo = new DBfacaden();

	public void opretKunde(Kunde kunde) throws AdresseIkkeOplystException, ByIkkeOplystException,
			EfternavnIkkeOplystException, EmailIkkeOplystException, FodselsdagIkkeOplystException,
			FornavnIkkeOplystException, PostnummerIkkeOplystException, TelefonnummerIkkeOplystException {
		opretKundeInfo.opretKundeInfo(kunde);
	}

	// Opret Sælger
	private DBfacaden opretSælgerInfo = new DBfacaden();

	public void opretSælger(Sælger sælger) throws MangledeInformationOmSælgerException {
		opretSælgerInfo.opretSælgerInfo(sælger);
	}

	// Opret Bil
	private DBfacaden opretBilInfo = new DBfacaden();

	public void opretBil(Bil bil)
			throws ModelIkkeOplystException, StelnummerIkkeOplystException, ÅrgangIkkeOplystException {
		opretBilInfo.opretBilInfo(bil);
	}
}
