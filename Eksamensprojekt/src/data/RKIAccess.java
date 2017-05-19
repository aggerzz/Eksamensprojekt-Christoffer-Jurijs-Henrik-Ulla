package data;
import com.ferrari.finances.dk.rki.CreditRator;

import domain.Låneanmodning;
import domain.Låneanmodninglmpl;
public class RKIAccess extends Thread {
	
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
	
	public void getKreditværdighed(){
		System.out.println("Personnummer: " + PersonNummer);
		CreditRator creditRator = CreditRator.i();
		System.out.println(creditRator.rate(PersonNummer));

		switch (creditRator.rate(PersonNummer)){
		
		case A: låneanmodning.kreditværdighed = 'A';
		break;
		case B: låneanmodning.kreditværdighed = 'B';
		break;
		case C: låneanmodning.kreditværdighed = 'C';
		break;
		case D: låneanmodning.kreditværdighed = 'D';
		break;
		default: låneanmodning.kreditværdighed = 'X';

		}
	}
	
		public Låneanmodning getLåneanmodning(){
			return låneanmodning;
		}
	}


