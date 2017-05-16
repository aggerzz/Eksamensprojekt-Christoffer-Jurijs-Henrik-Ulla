package test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Sælger;
import domain.Sælgerlmpl;
import exceptions.AdgangskodeIkkeOplystException;
import exceptions.BrugernavnIkkeOplystException;
import exceptions.EfternavnIkkeOplystException;
import exceptions.EmailIkkeOplystException;
import exceptions.FornavnIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;
import logic.FFLogic;

public class OC2opretSælger {

	@Test
	public void testOprettelseAfNySælger()
			throws FornavnIkkeOplystException, EfternavnIkkeOplystException, TelefonnummerIkkeOplystException,
			EmailIkkeOplystException, BrugernavnIkkeOplystException, AdgangskodeIkkeOplystException {
		Sælger nysælger = new Sælgerlmpl();
		FFLogic logic = new FFLogic();

		nysælger.setLogin("Pet0r");
		nysælger.setAdgangskode("Jensen");
		nysælger.setForNavn("Peter");
		nysælger.setEfterNavn("Jensen");
		nysælger.setTelefonNummer("34235632");
		nysælger.setEmail("Peterjensen@live.dk");

		logic.opretSælger(nysælger);
	}

	@Test(expected = FornavnIkkeOplystException.class)
	public void testFornavnIkkeOplystException()
			throws FornavnIkkeOplystException, EfternavnIkkeOplystException, TelefonnummerIkkeOplystException,
			EmailIkkeOplystException, BrugernavnIkkeOplystException, AdgangskodeIkkeOplystException {
		Sælger nysælger = new Sælgerlmpl();
		FFLogic logic = new FFLogic();

		nysælger.setLogin("Pet0r");
		nysælger.setAdgangskode("Jensen");
		nysælger.setForNavn("");
		nysælger.setEfterNavn("Jensen");
		nysælger.setTelefonNummer("34235632");
		nysælger.setEmail("Peterjensen@live.dk");

		logic.opretSælger(nysælger);

		fail("MangledeInformationOmSælger ej indtruffet");
	}
	
	@Test(expected = EfternavnIkkeOplystException.class)
	public void testEfternavnIkkeOplystException()
			throws FornavnIkkeOplystException, EfternavnIkkeOplystException, TelefonnummerIkkeOplystException,
			EmailIkkeOplystException, BrugernavnIkkeOplystException, AdgangskodeIkkeOplystException {
		Sælger nysælger = new Sælgerlmpl();
		FFLogic logic = new FFLogic();

		nysælger.setLogin("Pet0r");
		nysælger.setAdgangskode("Jensen");
		nysælger.setForNavn("Peter");
		nysælger.setEfterNavn("");
		nysælger.setTelefonNummer("34235632");
		nysælger.setEmail("Peterjensen@live.dk");

		logic.opretSælger(nysælger);

		fail("MangledeInformationOmSælger ej indtruffet");
	}
	
	@Test(expected = TelefonnummerIkkeOplystException.class)
	public void testTelefonnummerIkkeOplystException()
			throws FornavnIkkeOplystException, EfternavnIkkeOplystException, TelefonnummerIkkeOplystException,
			EmailIkkeOplystException, BrugernavnIkkeOplystException, AdgangskodeIkkeOplystException {
		Sælger nysælger = new Sælgerlmpl();
		FFLogic logic = new FFLogic();

		nysælger.setLogin("Pet0r");
		nysælger.setAdgangskode("Jensen");
		nysælger.setForNavn("Peter");
		nysælger.setEfterNavn("Jensen");
		nysælger.setTelefonNummer("");
		nysælger.setEmail("Peterjensen@live.dk");

		logic.opretSælger(nysælger);

		fail("MangledeInformationOmSælger ej indtruffet");
	}
	
	@Test(expected = EmailIkkeOplystException.class)
	public void testEmailIkkeOplystException()
			throws FornavnIkkeOplystException, EfternavnIkkeOplystException, TelefonnummerIkkeOplystException,
			EmailIkkeOplystException, BrugernavnIkkeOplystException, AdgangskodeIkkeOplystException {
		Sælger nysælger = new Sælgerlmpl();
		FFLogic logic = new FFLogic();

		nysælger.setLogin("Pet0r");
		nysælger.setAdgangskode("Jensen");
		nysælger.setForNavn("Peter");
		nysælger.setEfterNavn("Jensen");
		nysælger.setTelefonNummer("34235632");
		nysælger.setEmail("");

		logic.opretSælger(nysælger);

		fail("MangledeInformationOmSælger ej indtruffet");
	}
	
	@Test(expected = BrugernavnIkkeOplystException.class)
	public void testBrugernavnIkkeOplystException()
			throws FornavnIkkeOplystException, EfternavnIkkeOplystException, TelefonnummerIkkeOplystException,
			EmailIkkeOplystException, BrugernavnIkkeOplystException, AdgangskodeIkkeOplystException {
		Sælger nysælger = new Sælgerlmpl();
		FFLogic logic = new FFLogic();

		nysælger.setLogin("");
		nysælger.setAdgangskode("Jensen");
		nysælger.setForNavn("Peter");
		nysælger.setEfterNavn("Jensen");
		nysælger.setTelefonNummer("34235632");
		nysælger.setEmail("Peterjensen@live.dk");

		logic.opretSælger(nysælger);

		fail("MangledeInformationOmSælger ej indtruffet");
	}
	
	@Test(expected = AdgangskodeIkkeOplystException.class)
	public void testAdgangskodeIkkeOplystException()
			throws FornavnIkkeOplystException, EfternavnIkkeOplystException, TelefonnummerIkkeOplystException,
			EmailIkkeOplystException, BrugernavnIkkeOplystException, AdgangskodeIkkeOplystException {
		Sælger nysælger = new Sælgerlmpl();
		FFLogic logic = new FFLogic();

		nysælger.setLogin("Pet0r");
		nysælger.setAdgangskode("");
		nysælger.setForNavn("Peter");
		nysælger.setEfterNavn("Jensen");
		nysælger.setTelefonNummer("34235632");
		nysælger.setEmail("Peterjensen@live.dk");

		logic.opretSælger(nysælger);

		fail("MangledeInformationOmSælger ej indtruffet");
	}
}