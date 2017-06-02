package access;

import logic.BeregnRente;
import com.ferrari.finances.dk.bank.InterestRate;

import domain.Låneanmodning;
import domain.Låneanmodninglmpl;

public class BankAccess implements Runnable {

	private Låneanmodning låneanmodning;

	public BankAccess(Låneanmodning låneanmodning) {
		this.låneanmodning = låneanmodning;
	}

	@Override
	public void run() {
		HentRenteVurdering();
		låneanmodning.setRentesats(HentRenteVurdering());

	}

	public double HentRenteVurdering() {
		InterestRate interestRate = InterestRate.i();
		double rentesats = interestRate.todaysRate();

		return rentesats;
	}

	public Låneanmodning getLaaneAnmodning() {
		return låneanmodning;
	}

}