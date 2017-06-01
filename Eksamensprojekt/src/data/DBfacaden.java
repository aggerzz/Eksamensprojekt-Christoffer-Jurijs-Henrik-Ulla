package data;

import java.util.List;

import data.OpretKundeDB;
import domain.Bil;
import domain.Kunde;
import domain.Låneanmodning;
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

public class DBfacaden {

	private OpretKundeDB opretKundeInfo = new OpretKundeDB();

	public void opretKundeInfo(Kunde kunde) throws AdresseIkkeOplystException, ByIkkeOplystException,
			EfternavnIkkeOplystException, EmailIkkeOplystException, FodselsdagIkkeOplystException,
			FornavnIkkeOplystException, PostnummerIkkeOplystException, TelefonnummerIkkeOplystException {
		opretKundeInfo.opretKunde(kunde);
	}

	private OpretSælgerDB opretSælgerInfo = new OpretSælgerDB();

	public void opretSælgerInfo(Sælger sælger)
			throws FornavnIkkeOplystException, EfternavnIkkeOplystException, TelefonnummerIkkeOplystException,
			EmailIkkeOplystException, BrugernavnIkkeOplystException, AdgangskodeIkkeOplystException {
		opretSælgerInfo.opretSælger(sælger);
	}

	private OpretBilDB opretBilInfo = new OpretBilDB();

	public void opretBilInfo(Bil bil) throws ModelIkkeOplystException, StelnummerIkkeOplystException,
			ÅrgangIkkeOplystException, PrisIkkeOplystException {
		opretBilInfo.opretBil(bil);
	}

	private OpretLåneanmodningDB opretLåneanmodningInfo = new OpretLåneanmodningDB();

	public void opretLåneanmodningInfo(Låneanmodning låneanmodning)
			throws Exception {
		opretLåneanmodningInfo.opretLåneanmodning(låneanmodning);
	}
	private GetBilDB findBilInfo = new GetBilDB();

	public void findBilInfo(Bil bil) throws ModelIkkeOplystException, StelnummerIkkeOplystException,
			ÅrgangIkkeOplystException, PrisIkkeOplystException {
		findBilInfo.findBil(bil);
	}
	private IdDB userInfo = new IdDB();

	public void userInfo(Sælger sælger) throws Exception {
		userInfo.CheckID(sælger);
	}
	// Find Kunde
	private GetKundeDB findKunder = new GetKundeDB();

	public List<Kunde> findKunder(Kunde kunde) throws Exception {
		return findKunder.findKunde(kunde);
	}
	// Find Biler
	private GetBilerDB findBiler = new GetBilerDB();

	public List<Bil> findBiler(Bil bil) throws Exception {
		return findBiler.findBiler(bil);
	}
	// Find Sælger
	private SælgerInfoDB findSælger = new SælgerInfoDB();

	public List<Sælger> findSælger(Sælger sælger) throws Exception {
		return findSælger.findSælger(sælger);
	}
	// Find Lån
		private LåneInfoDB findLån = new LåneInfoDB();

		public List<Låneanmodning> findLån(Låneanmodning låneanmodning) throws Exception {
			return findLån.findLån(låneanmodning);
		}
	
}
