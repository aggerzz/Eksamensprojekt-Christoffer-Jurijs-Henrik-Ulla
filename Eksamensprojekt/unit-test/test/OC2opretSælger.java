package test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Sælger;
import domain.Sælgerlmpl;
import exceptions.MangledeInformationOmSælgerException;
import logic.FFLogic;

public class OC2opretSælger {

	@Test
	public void testOprettelseAfNySælger() throws MangledeInformationOmSælgerException{
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

	@Test(expected = MangledeInformationOmSælgerException.class)
	public void testMangledeInformationOmkringSælgeren()
			throws MangledeInformationOmSælgerException {
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
}