package test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Låneanmodning;
import domain.Låneanmodninglmpl;
import exceptions.KreditværdighedIkkeUdfyldtException;
import exceptions.LøbetidIkkeUdfyldtException;
import exceptions.PersonnummerIkkeUdfyldtException;
import exceptions.RentesatsIkkeUdfyldtException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;
import logic.FFLogic;

public class TestLåneanmodning {

	@Test
	public void testOprettelseAfNyLåneanmodning()
			throws Exception {
		Låneanmodning nylåneanmodning = new Låneanmodninglmpl();
		FFLogic logic = new FFLogic();

		nylåneanmodning.setKreditværdighed('A');
		nylåneanmodning.setLøbetid(36);
		nylåneanmodning.setRentesats(5.62);
		nylåneanmodning.setPersonNummer("0205938272");
		nylåneanmodning.setStelNummer("CC3483J");
		nylåneanmodning.setTelefonNummer("34235632");
		nylåneanmodning.setUdbetaling(456465);
		nylåneanmodning.setMånedligYdelse(0);
		nylåneanmodning.setPris(0);
		nylåneanmodning.setPrisEfterRente(0);
		nylåneanmodning.setSælgerID(0);
		nylåneanmodning.setUdbetaling(0);
		
		logic.opretLåneanmodning(nylåneanmodning);
	}

	@Test
	public void testgetUdbetaling()
			throws StelnummerIkkeOplystException, KreditværdighedIkkeUdfyldtException, PersonnummerIkkeUdfyldtException,
			TelefonnummerIkkeOplystException, RentesatsIkkeUdfyldtException, LøbetidIkkeUdfyldtException {
		Låneanmodning nylåneanmodning = new Låneanmodninglmpl();

		nylåneanmodning.setUdbetaling(456465);

		assertEquals(456465, nylåneanmodning.getUdbetaling(), 0.001);
	}
}
