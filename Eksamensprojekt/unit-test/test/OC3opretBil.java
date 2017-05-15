package test;

import static org.junit.Assert.*;
import org.junit.Test;
import domain.Bil;
import domain.Billmpl;
import exceptions.ModelIkkeOplystException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.ÅrgangIkkeOplystException;
import logic.FFLogic;

public class OC3opretBil {

	@Test
	public void testOprettelseAfNyBil() throws ModelIkkeOplystException, StelnummerIkkeOplystException, ÅrgangIkkeOplystException{
		Bil nybil = new Billmpl();
		FFLogic logic = new FFLogic();
		
		nybil.setModel("GTC4Lusso");
		nybil.setStelNummer("CC3483J");
		nybil.setÅrgang("2017");
		
		logic.opretBil(nybil);
	}

	@Test(expected = ModelIkkeOplystException.class)
	public void testModelIkkkeOplyst()
			throws ModelIkkeOplystException, StelnummerIkkeOplystException, ÅrgangIkkeOplystException {
		Bil nybil = new Billmpl();
		FFLogic logic = new FFLogic();
		
		nybil.setModel("");
		nybil.setStelNummer("CC3483J");
		nybil.setÅrgang("2017");
		
		logic.opretBil(nybil);

		
		fail("MangledeInformationOmBilen ej indtruffet");
	}
	
	@Test(expected = StelnummerIkkeOplystException.class)
	public void testStelnummerIkkkeOplyst()
			throws ModelIkkeOplystException, StelnummerIkkeOplystException, ÅrgangIkkeOplystException {
		Bil nybil = new Billmpl();
		FFLogic logic = new FFLogic();
		
		nybil.setModel("GTC4Lusso");
		nybil.setStelNummer("");
		nybil.setÅrgang("2017");
		
		logic.opretBil(nybil);

		
		fail("MangledeInformationOmBilen ej indtruffet");
	}
	
	@Test(expected = ÅrgangIkkeOplystException.class)
	public void testÅrgangIkkkeOplyst()
			throws ModelIkkeOplystException, StelnummerIkkeOplystException, ÅrgangIkkeOplystException {
		Bil nybil = new Billmpl();
		FFLogic logic = new FFLogic();
		
		nybil.setModel("GTC4Lusso");
		nybil.setStelNummer("CC3483J");
		nybil.setÅrgang("");
		
		logic.opretBil(nybil);

		
		fail("MangledeInformationOmBilen ej indtruffet");
	}
}