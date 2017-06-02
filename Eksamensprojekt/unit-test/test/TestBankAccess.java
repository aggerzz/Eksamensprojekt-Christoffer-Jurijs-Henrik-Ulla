package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ferrari.finances.dk.bank.InterestRate;

import access.BankAccess;
import domain.Låneanmodninglmpl;

public class TestBankAccess {

	@Test
	public void testGetDagensRente() {
		BankAccess bankAccess = new BankAccess(new Låneanmodninglmpl());
		InterestRate interestRate = InterestRate.i();

		System.out.println("Rente fra Jar: " + interestRate.todaysRate());
		System.out.println("Rente fra Bank: " + bankAccess.HentRenteVurdering());

		assertEquals(interestRate.todaysRate(), bankAccess.HentRenteVurdering(), 0.001);
	}
}
