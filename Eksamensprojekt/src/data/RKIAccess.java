package data;
import com.ferrari.finances.dk.rki.CreditRator;

import domain.Låneanmodninglmpl;
public class RKIAccess implements Runnable {
	
	private String PersonNummer;
	private Låneanmodninglmpl låneanmodning;

	public RKIAccess(Låneanmodninglmpl låneanmodning, String PersonNummer){
		this.låneanmodning = låneanmodning;
		this.PersonNummer = PersonNummer;
	}
	
	@Override
	public void run() {
		getKreditværdighed();
		// TODO Auto-generated method stub
		
	}
	
	private void getKreditværdighed(){
		CreditRator creditRator = CreditRator.i();
		
		switch (creditRator.rate(PersonNummer)){
		
		case A: låneanmodning.kreditværdighed = 'A';
		case B: låneanmodning.kreditværdighed = 'B';
		case C: låneanmodning.kreditværdighed = 'C';
		case D: låneanmodning.kreditværdighed = 'D';
		default: låneanmodning.kreditværdighed = 'X';

		}
	}

}
