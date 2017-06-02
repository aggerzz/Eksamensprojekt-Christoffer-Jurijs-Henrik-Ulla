package access;

import com.ferrari.finances.dk.bank.InterestRate;
import domain.Låneanmodning;

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