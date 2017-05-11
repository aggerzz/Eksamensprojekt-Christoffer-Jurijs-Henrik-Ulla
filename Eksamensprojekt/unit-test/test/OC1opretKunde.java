package test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Kunde;
import domain.Kundelmpl;
import exceptions.MangledeInformationOmKundenException;
import logic.FFLogic;

public class OC1opretKunde {
	
	@Test
	public void testOprettelseAfNyKunde() throws MangledeInformationOmKundenException{
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

	@Test(expected = MangledeInformationOmKundenException.class)
	public void testMangledeInformationOmkringKunden()
			throws MangledeInformationOmKundenException {
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
}