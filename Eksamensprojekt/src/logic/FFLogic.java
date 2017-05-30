package logic;

import java.util.List;

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
import exceptions.KreditværdighedIkkeUdfyldtException;
import exceptions.LøbetidIkkeUdfyldtException;
import exceptions.PostnummerIkkeOplystException;
import exceptions.PrisIkkeOplystException;
import exceptions.RentesatsIkkeUdfyldtException;
import exceptions.TelefonnummerIkkeOplystException;
import exceptions.ModelIkkeOplystException;
import exceptions.PersonnummerIkkeUdfyldtException;
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

	public void opretSælger(Sælger sælger)
			throws FornavnIkkeOplystException, EfternavnIkkeOplystException, TelefonnummerIkkeOplystException,
			EmailIkkeOplystException, BrugernavnIkkeOplystException, AdgangskodeIkkeOplystException {
		opretSælgerInfo.opretSælgerInfo(sælger);
	}

	// Opret Bil
	private DBfacaden opretBilInfo = new DBfacaden();

	public void opretBil(Bil bil) throws ModelIkkeOplystException, StelnummerIkkeOplystException,
			ÅrgangIkkeOplystException, PrisIkkeOplystException {
		opretBilInfo.opretBilInfo(bil);
	}
	// Find Bil
	private DBfacaden findBilInfo = new DBfacaden();
	
	public void findBil(Bil bil) throws ModelIkkeOplystException, StelnummerIkkeOplystException,
			ÅrgangIkkeOplystException, PrisIkkeOplystException {
		findBilInfo.findBilInfo(bil);}
	// Opret Låneanmodning
	private DBfacaden opretLåneanmodningInfo = new DBfacaden();

	public void opretLåneanmodning(Låneanmodning låneanmodning)
			throws StelnummerIkkeOplystException, KreditværdighedIkkeUdfyldtException, PersonnummerIkkeUdfyldtException,
			TelefonnummerIkkeOplystException, RentesatsIkkeUdfyldtException, LøbetidIkkeUdfyldtException {
		opretLåneanmodningInfo.opretLåneanmodningInfo(låneanmodning);
	}
	// Select Matches
	private static DBfacaden kundeAccess = new DBfacaden();

	public static List<Kunde> getKunde() throws Exception {
		return kundeAccess.findKunder();
	}
	//
	public void getKreditværdighed(String personNummer, Låneanmodninglmpl låneanmodning) throws KreditværdighedIkkeUdfyldtException {
		Runnable rkiAccess = new RKIAccess(låneanmodning, personNummer);
		Thread getKreditværdighedThread = new Thread(rkiAccess, personNummer);
		getKreditværdighedThread.start();
	}
}
