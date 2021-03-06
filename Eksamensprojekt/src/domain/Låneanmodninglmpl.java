package domain;

import exceptions.KreditværdighedIkkeUdfyldtException;
import exceptions.LøbetidIkkeUdfyldtException;
import exceptions.PersonnummerIkkeUdfyldtException;
import exceptions.RentesatsIkkeUdfyldtException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;

public class Låneanmodninglmpl implements Låneanmodning {
	private int sælgerID;
	private String personNummer;
	private String telefonNummer;
	public char kreditværdighed;
	private double månedligYdelse;
	private double prisEfterRente;
	private double rentesats;
	private String stelNummer;
	private int løbetid;
	private double udbetaling;
	private double pris;

	public double getUdbetaling() {
		return udbetaling;
	}

	public void setUdbetaling(double udbetaling) {
		this.udbetaling = udbetaling;
	}

	public String getPersonNummer() throws PersonnummerIkkeUdfyldtException {
		if (personNummer.isEmpty())
			throw new PersonnummerIkkeUdfyldtException();
		return personNummer;
	}

	public void setPersonNummer(String personNummer) {
		this.personNummer = personNummer;
	}

	public String getTelefonNummer() throws TelefonnummerIkkeOplystException {
		if (telefonNummer.isEmpty())
			throw new TelefonnummerIkkeOplystException();
		return telefonNummer;
	}

	public void setTelefonNummer(String telefonNummer) {
		this.telefonNummer = telefonNummer;
	}

	public char getKreditværdighed() throws KreditværdighedIkkeUdfyldtException {
		if (kreditværdighed == ' ')
			throw new KreditværdighedIkkeUdfyldtException();
		return kreditværdighed;
	}

	public void setKreditværdighed(char kreditværdighed) {
		this.kreditværdighed = kreditværdighed;
	}

	public double getRentesats() throws RentesatsIkkeUdfyldtException {
		if (rentesats == 0)
			throw new RentesatsIkkeUdfyldtException();
		return rentesats;
	}

	public void setRentesats(double rentesats) {
		this.rentesats = rentesats;
	}

	public String getStelNummer() throws StelnummerIkkeOplystException {
		if (stelNummer.isEmpty())
			throw new StelnummerIkkeOplystException();
		return stelNummer;
	}

	public void setStelNummer(String stelNummer) {
		this.stelNummer = stelNummer;
	}

	public int getLøbetid() throws LøbetidIkkeUdfyldtException {
		if (løbetid == 0)
			throw new LøbetidIkkeUdfyldtException();
		return løbetid;
	}

	public void setLøbetid(int løbetid) {
		this.løbetid = løbetid;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public int getSælgerID() {
		return sælgerID;
	}

	public void setSælgerID(int sælgerID) {
		this.sælgerID = sælgerID;
	}

	public double getMånedligYdelse() {
		return månedligYdelse;
	}

	public void setMånedligYdelse(double månedligYdelse) {
		this.månedligYdelse = månedligYdelse;
	}

	public double getPrisEfterRente() {
		return prisEfterRente;
	}

	public void setPrisEfterRente(double prisEfterRente) {
		this.prisEfterRente = prisEfterRente;
	}

}
