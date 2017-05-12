package test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Bil;
import domain.Billmpl;
import exceptions.MangledeInformationOmBilenException;
import logic.FFLogic;

public class OC3opretBil {

	@Test
	public void testOprettelseAfNyBil() throws MangledeInformationOmBilenException{
		Bil nybil = new Billmpl();
		FFLogic logic = new FFLogic();
		
		nybil.setModel("GTC4Lusso");
		nybil.setStelNummer("CC3483J");
		nybil.setÅrgang("2017");
		
		logic.opretBil(nybil);
	}

	@Test(expected = MangledeInformationOmBilenException.class)
	public void testMangledeInformationOmkringBilen()
			throws MangledeInformationOmBilenException {
		Bil nybil = new Billmpl();
		FFLogic logic = new FFLogic();
		
		nybil.setModel("GTC4Lusso");
		nybil.setStelNummer("CC3483J");
		nybil.setÅrgang("");
		
		logic.opretBil(nybil);

		
		fail("MangledeInformationOmBilen ej indtruffet");
	}
}