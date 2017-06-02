package test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Kunde;
import domain.Kundelmpl;
import exceptions.AdresseIkkeOplystException;
import exceptions.ByIkkeOplystException;
import exceptions.EfternavnIkkeOplystException;
import exceptions.EmailIkkeOplystException;
import exceptions.FodselsdagIkkeOplystException;
import exceptions.FornavnIkkeOplystException;
import exceptions.PostnummerIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;
import logic.FFLogic;

public class TestKunde {

	@Test
	public void testOprettelseAfNyKunde() throws AdresseIkkeOplystException, ByIkkeOplystException,
			EfternavnIkkeOplystException, EmailIkkeOplystException, FodselsdagIkkeOplystException,
			FornavnIkkeOplystException, PostnummerIkkeOplystException, TelefonnummerIkkeOplystException {
		Kunde nykunde = new Kundelmpl();
		FFLogic logic = new FFLogic();

		nykunde.setForNavn("Peter");
		nykunde.setEfterNavn("Jensen");
		nykunde.setAdresse("Skolebyen 5");
		nykunde.setBy("Herning");
		nykunde.setPostNummer("6940");
		nykunde.setFodselsdato("22-11-1990");
		nykunde.setTelefonNummer("34235632");
		nykunde.setEmail("Peterjensen@live.dk");

		logic.opretKunde(nykunde);
	}

	@Test(expected = FornavnIkkeOplystException.class)
	public void testFornavnIkkeOplystException() throws AdresseIkkeOplystException, ByIkkeOplystException,
			EfternavnIkkeOplystException, EmailIkkeOplystException, FodselsdagIkkeOplystException,
			FornavnIkkeOplystException, PostnummerIkkeOplystException, TelefonnummerIkkeOplystException {
		Kunde nykunde = new Kundelmpl();
		FFLogic logic = new FFLogic();

		nykunde.setForNavn("");
		nykunde.setEfterNavn("Jensen");
		nykunde.setAdresse("Skolebyen 5");
		nykunde.setBy("Herning");
		nykunde.setPostNummer("6940");
		nykunde.setFodselsdato("22-11-1990");
		nykunde.setTelefonNummer("34235632");
		nykunde.setEmail("Peterjensen@live.dk");

		logic.opretKunde(nykunde);

		fail("MangledeInformationOmkunden ej indtruffet");
	}

	@Test(expected = EfternavnIkkeOplystException.class)
	public void testEfternavnIkkeOplystException() throws AdresseIkkeOplystException, ByIkkeOplystException,
			EfternavnIkkeOplystException, EmailIkkeOplystException, FodselsdagIkkeOplystException,
			FornavnIkkeOplystException, PostnummerIkkeOplystException, TelefonnummerIkkeOplystException {
		Kunde nykunde = new Kundelmpl();
		FFLogic logic = new FFLogic();

		nykunde.setForNavn("Peter");
		nykunde.setEfterNavn("");
		nykunde.setAdresse("Skolebyen 5");
		nykunde.setBy("Herning");
		nykunde.setPostNummer("6940");
		nykunde.setFodselsdato("22-11-1990");
		nykunde.setTelefonNummer("34235632");
		nykunde.setEmail("Peterjensen@live.dk");

		logic.opretKunde(nykunde);

		fail("MangledeInformationOmkunden ej indtruffet");
	}

	@Test(expected = AdresseIkkeOplystException.class)
	public void testAdresseIkkeOplystException() throws AdresseIkkeOplystException, ByIkkeOplystException,
			EfternavnIkkeOplystException, EmailIkkeOplystException, FodselsdagIkkeOplystException,
			FornavnIkkeOplystException, PostnummerIkkeOplystException, TelefonnummerIkkeOplystException {
		Kunde nykunde = new Kundelmpl();
		FFLogic logic = new FFLogic();

		nykunde.setForNavn("Peter");
		nykunde.setEfterNavn("Jensen");
		nykunde.setAdresse("");
		nykunde.setBy("Herning");
		nykunde.setPostNummer("6940");
		nykunde.setFodselsdato("22-11-1990");
		nykunde.setTelefonNummer("34235632");
		nykunde.setEmail("Peterjensen@live.dk");

		logic.opretKunde(nykunde);

		fail("MangledeInformationOmkunden ej indtruffet");
	}

	@Test(expected = ByIkkeOplystException.class)
	public void testByIkkeOplystException() throws AdresseIkkeOplystException, ByIkkeOplystException,
			EfternavnIkkeOplystException, EmailIkkeOplystException, FodselsdagIkkeOplystException,
			FornavnIkkeOplystException, PostnummerIkkeOplystException, TelefonnummerIkkeOplystException {
		Kunde nykunde = new Kundelmpl();
		FFLogic logic = new FFLogic();

		nykunde.setForNavn("Peter");
		nykunde.setEfterNavn("Jensen");
		nykunde.setAdresse("Skolebyen 5");
		nykunde.setBy("");
		nykunde.setPostNummer("6940");
		nykunde.setFodselsdato("22-11-1990");
		nykunde.setTelefonNummer("34235632");
		nykunde.setEmail("Peterjensen@live.dk");

		logic.opretKunde(nykunde);

		fail("MangledeInformationOmkunden ej indtruffet");
	}

	@Test(expected = PostnummerIkkeOplystException.class)
	public void testPostnummerIkkeOplystException() throws AdresseIkkeOplystException, ByIkkeOplystException,
			EfternavnIkkeOplystException, EmailIkkeOplystException, FodselsdagIkkeOplystException,
			FornavnIkkeOplystException, PostnummerIkkeOplystException, TelefonnummerIkkeOplystException {
		Kunde nykunde = new Kundelmpl();
		FFLogic logic = new FFLogic();

		nykunde.setForNavn("Peter");
		nykunde.setEfterNavn("Jensen");
		nykunde.setAdresse("Skolebyen 5");
		nykunde.setBy("Herning");
		nykunde.setPostNummer("");
		nykunde.setFodselsdato("22-11-1990");
		nykunde.setTelefonNummer("34235632");
		nykunde.setEmail("Peterjensen@live.dk");

		logic.opretKunde(nykunde);

		fail("MangledeInformationOmkunden ej indtruffet");
	}

	@Test(expected = FodselsdagIkkeOplystException.class)
	public void testFodselsdagIkkeOplystException() throws AdresseIkkeOplystException, ByIkkeOplystException,
			EfternavnIkkeOplystException, EmailIkkeOplystException, FodselsdagIkkeOplystException,
			FornavnIkkeOplystException, PostnummerIkkeOplystException, TelefonnummerIkkeOplystException {
		Kunde nykunde = new Kundelmpl();
		FFLogic logic = new FFLogic();

		nykunde.setForNavn("Peter");
		nykunde.setEfterNavn("Jensen");
		nykunde.setAdresse("Skolebyen 5");
		nykunde.setBy("Herning");
		nykunde.setPostNummer("6940");
		nykunde.setFodselsdato("");
		nykunde.setTelefonNummer("34235632");
		nykunde.setEmail("Peterjensen@live.dk");

		logic.opretKunde(nykunde);

		fail("MangledeInformationOmkunden ej indtruffet");
	}

	@Test(expected = TelefonnummerIkkeOplystException.class)
	public void testTelefonnummerIkkeOplystException() throws AdresseIkkeOplystException, ByIkkeOplystException,
			EfternavnIkkeOplystException, EmailIkkeOplystException, FodselsdagIkkeOplystException,
			FornavnIkkeOplystException, PostnummerIkkeOplystException, TelefonnummerIkkeOplystException {
		Kunde nykunde = new Kundelmpl();
		FFLogic logic = new FFLogic();

		nykunde.setForNavn("Peter");
		nykunde.setEfterNavn("Jensen");
		nykunde.setAdresse("Skolebyen 5");
		nykunde.setBy("Herning");
		nykunde.setPostNummer("6940");
		nykunde.setFodselsdato("22-11-1990");
		nykunde.setTelefonNummer("");
		nykunde.setEmail("Peterjensen@live.dk");

		logic.opretKunde(nykunde);

		fail("MangledeInformationOmkunden ej indtruffet");
	}

	@Test(expected = EmailIkkeOplystException.class)
	public void testEmailIkkeOplystException() throws AdresseIkkeOplystException, ByIkkeOplystException,
			EfternavnIkkeOplystException, EmailIkkeOplystException, FodselsdagIkkeOplystException,
			FornavnIkkeOplystException, PostnummerIkkeOplystException, TelefonnummerIkkeOplystException {
		Kunde nykunde = new Kundelmpl();
		FFLogic logic = new FFLogic();

		nykunde.setForNavn("Peter");
		nykunde.setEfterNavn("Jensen");
		nykunde.setAdresse("Skolebyen 5");
		nykunde.setBy("Herning");
		nykunde.setPostNummer("6940");
		nykunde.setFodselsdato("22-11-1990");
		nykunde.setTelefonNummer("34235632");
		nykunde.setEmail("");

		logic.opretKunde(nykunde);

		fail("MangledeInformationOmkunden ej indtruffet");
	}

	@Test
	public void testgetFornavn() throws AdresseIkkeOplystException, ByIkkeOplystException, EfternavnIkkeOplystException,
			EmailIkkeOplystException, FodselsdagIkkeOplystException, FornavnIkkeOplystException,
			PostnummerIkkeOplystException, TelefonnummerIkkeOplystException {
		Kunde nykunde = new Kundelmpl();

		nykunde.setForNavn("peter");

		assertEquals("peter", nykunde.getForNavn());

	}
}