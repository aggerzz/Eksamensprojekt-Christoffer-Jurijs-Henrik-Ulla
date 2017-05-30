package logic;

import access.RKIAccess;
import data.DBfacaden;
import domain.Bil;
import domain.Kunde;
import domain.Låneanmodning;
import domain.Låneanmodninglmpl;
import domain.Sælger;
import exceptions.AdgangskodeIkkeOplystException;
import exceptions.AdresseIkkeOplystException;
import exceptions.BrugernavnIkkeOplystException;
import exceptions.ByIkkeOplystException;
import exceptions.EfternavnIkkeOplystException;
import exceptions.EmailIkkeOplystException;
import exceptions.FodselsdagIkkeOplystException;
import exceptions.FornavnIkkeOplystException;
import exceptions.PostnummerIkkeOplystException;
import exceptions.PrisIkkeOplystException;
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

	public void opretSælger(Sælger sælger) throws FornavnIkkeOplystException, EfternavnIkkeOplystException, TelefonnummerIkkeOplystException,
	EmailIkkeOplystException, BrugernavnIkkeOplystException, AdgangskodeIkkeOplystException {
		opretSælgerInfo.opretSælgerInfo(sælger);
	}

	// Opret Bil
	private DBfacaden opretBilInfo = new DBfacaden();

	public void opretBil(Bil bil)
			throws ModelIkkeOplystException, StelnummerIkkeOplystException, ÅrgangIkkeOplystException, PrisIkkeOplystException {
		opretBilInfo.opretBilInfo(bil);
	}
	// Opret Låneanmodning
	private DBfacaden opretLåneanmodningInfo = new DBfacaden();

	public void opretLåneanmodning(Låneanmodning låneanmodning)
			throws Exception {
		opretLåneanmodningInfo.opretLåneanmodningInfo(låneanmodning);
	}
	//
	public void getKreditværdighed(String personNummer,Låneanmodninglmpl låneanmodning) {
		Runnable rkiAccess = new RKIAccess(låneanmodning, personNummer);
		Thread getKreditværdighedThread = new Thread(rkiAccess, personNummer);
		getKreditværdighedThread.start();		
	}
}
