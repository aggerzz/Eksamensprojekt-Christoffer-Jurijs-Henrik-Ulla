package access;
import logic.BeregnRente;
import com.ferrari.finances.dk.bank.InterestRate;

public class BankAccess implements Runnable{
	
private BeregnRente beregnRente;

public BankAccess( BeregnRente beregnRente) {
	this.beregnRente = beregnRente;
}

@Override
public void run() {

	beregnRente.todaysRate = getTodaysRate();

}

public double getTodaysRate() {
	InterestRate interestRate = InterestRate.i();

	return interestRate.todaysRate();
}
}
