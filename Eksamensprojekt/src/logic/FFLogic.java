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
		findBilInfo.findBilInfo(bil);
		}
	// Find Id
	private DBfacaden userInfo = new DBfacaden();
	
	public void CheckID(Sælger sælger) throws Exception {
		userInfo.userInfo(sælger);
		}
	// Opret Låneanmodning
	private DBfacaden opretLåneanmodningInfo = new DBfacaden();

	public void opretLåneanmodning(Låneanmodning låneanmodning)
			throws Exception {
		opretLåneanmodningInfo.opretLåneanmodningInfo(låneanmodning);
	}
	// Find Kunder
	private static DBfacaden kundeAccess = new DBfacaden();

	public static List<Kunde> getKunde(Kunde findKunde) throws Exception {
		return kundeAccess.findKunder(findKunde);
	}
	// Find Lån
		private static DBfacaden lånAccess = new DBfacaden();

		public static List<Låneanmodning> getLån(Låneanmodning findLån) throws Exception {
			return lånAccess.findLån(findLån);
		}
	// Find Sælger
	private static DBfacaden sælgerAccess = new DBfacaden();

	public static List<Sælger> getSælger(Sælger findSælger) throws Exception {
		return sælgerAccess.findSælger(findSælger);
	}
	// Find Biler
	private static DBfacaden bilAccess = new DBfacaden();

	public static List<Bil> getBil(Bil findBiler) throws Exception {
		return bilAccess.findBiler(findBiler);
	}
	
	//
	public void getKreditværdighed(String personNummer, Låneanmodninglmpl låneanmodning) throws KreditværdighedIkkeUdfyldtException {
		Runnable rkiAccess = new RKIAccess(låneanmodning, personNummer);
		Thread getKreditværdighedThread = new Thread(rkiAccess, personNummer);
		getKreditværdighedThread.start();
	}
}
