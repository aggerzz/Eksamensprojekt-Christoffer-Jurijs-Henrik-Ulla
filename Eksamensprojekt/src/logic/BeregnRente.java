package logic;

public class BeregnRente {

	public double rente = 0;

	public double beregnRente(char kreditværdighed, double todaysRate, double bilensPris, double udbetaling, int løbetid) {

		rente = todaysRate;

		kreditværdighed(kreditværdighed);
		betaltUnderHalvPris(udbetaling, bilensPris);
		overTreÅr(løbetid);

		return rente;

	}
public static double beregnPrisEfterRente ;
public double beregnPrisEfterRente(double beregnRente, double bilensPris, double udbetaling){
	return beregnPrisEfterRente = ((bilensPris-udbetaling)*Math.pow(rente, 1));
}
	private void kreditværdighed(char kreditværdighed) {
		switch (kreditværdighed) {
		case 'A':
			rente += 1;
			break;
		case 'B':
			rente += 2;
			break;
		case 'C':
			rente += 3;
			break;
		}

	}

	private void overTreÅr(int løbetid) {
		if (løbetid > 36) {
			rente += 1;
		}

	}

	private void betaltUnderHalvPris(double udbetaling, double bilensPris) {
		if (udbetaling < bilensPris / 2) {
			rente += 1;
		}

	}

}