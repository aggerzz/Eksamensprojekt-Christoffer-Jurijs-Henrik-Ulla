package test;

import static org.junit.Assert.*;
import org.junit.Test;
import domain.Bil;
import domain.Billmpl;
import exceptions.ModelIkkeOplystException;
import exceptions.PrisIkkeOplystException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.ÅrgangIkkeOplystException;
import logic.FFLogic;

public class TestBil {

	@Test
	public void testOprettelseAfNyBil() throws ModelIkkeOplystException, StelnummerIkkeOplystException,
			ÅrgangIkkeOplystException, PrisIkkeOplystException {
		Bil nybil = new Billmpl();
		FFLogic logic = new FFLogic();

		nybil.setModel("GTC4Lusso");
		nybil.setStelNummer("CC3483J");
		nybil.setÅrgang("2017");
		nybil.setPris("2.000.000");

		logic.opretBil(nybil);
	}

	@Test(expected = ModelIkkeOplystException.class)
	public void testModelIkkkeOplyst() throws ModelIkkeOplystException, StelnummerIkkeOplystException,
			ÅrgangIkkeOplystException, PrisIkkeOplystException {
		Bil nybil = new Billmpl();
		FFLogic logic = new FFLogic();

		nybil.setModel("");
		nybil.setStelNummer("CC3483J");
		nybil.setÅrgang("2017");
		nybil.setPris("2.000.000");

		logic.opretBil(nybil);

		fail("MangledeInformationOmBilen ej indtruffet");
	}

	@Test(expected = StelnummerIkkeOplystException.class)
	public void testStelnummerIkkkeOplyst() throws ModelIkkeOplystException, StelnummerIkkeOplystException,
			ÅrgangIkkeOplystException, PrisIkkeOplystException {
		Bil nybil = new Billmpl();
		FFLogic logic = new FFLogic();

		nybil.setModel("GTC4Lusso");
		nybil.setStelNummer("");
		nybil.setÅrgang("2017");
		nybil.setPris("2.000.000");

		logic.opretBil(nybil);

		fail("MangledeInformationOmBilen ej indtruffet");
	}

	@Test(expected = ÅrgangIkkeOplystException.class)
	public void testÅrgangIkkkeOplyst() throws ModelIkkeOplystException, StelnummerIkkeOplystException,
			ÅrgangIkkeOplystException, PrisIkkeOplystException {
		Bil nybil = new Billmpl();
		FFLogic logic = new FFLogic();

		nybil.setModel("GTC4Lusso");
		nybil.setStelNummer("CC3483J");
		nybil.setÅrgang("");
		nybil.setPris("2.000.000");

		logic.opretBil(nybil);

		fail("MangledeInformationOmBilen ej indtruffet");
	}

	@Test(expected = PrisIkkeOplystException.class)
	public void testPrisIkkkeOplyst() throws ModelIkkeOplystException, StelnummerIkkeOplystException,
			ÅrgangIkkeOplystException, PrisIkkeOplystException {
		Bil nybil = new Billmpl();
		FFLogic logic = new FFLogic();

		nybil.setModel("GTC4Lusso");
		nybil.setStelNummer("CC3483J");
		nybil.setÅrgang("2017");
		nybil.setPris("");

		logic.opretBil(nybil);

		fail("MangledeInformationOmBilen ej indtruffet");
	}

	@Test
	public void testGetModelForBil() throws ModelIkkeOplystException, StelnummerIkkeOplystException,
			ÅrgangIkkeOplystException, PrisIkkeOplystException {
		Bil nybil = new Billmpl();

		nybil.setModel("GTC4Lusso");

		assertEquals("GTC4Lusso", nybil.getModel());
	}

	@Test
	public void testsomething() throws ModelIkkeOplystException, StelnummerIkkeOplystException,
			ÅrgangIkkeOplystException, PrisIkkeOplystException {
		Bil nybil = new Billmpl();

		assertEquals(null, nybil.getModel());
	}
}