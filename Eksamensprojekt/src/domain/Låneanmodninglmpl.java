package domain;

import exceptions.KreditværdighedIkkeUdfyldtException;
import exceptions.LøbetidIkkeUdfyldtException;
import exceptions.PersonnummerIkkeUdfyldtException;
import exceptions.RentesatsIkkeUdfyldtException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;

public class Låneanmodninglmpl implements Låneanmodning {
	private String personNummer;
	private String telefonNummer;
	public char kreditværdighed;
	private String rentesats;
	private String stelNummer;
	private int løbetid;

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

	public char getKreditværdihed() throws KreditværdighedIkkeUdfyldtException {
		if (kreditværdighed == ' ')
			throw new KreditværdighedIkkeUdfyldtException();
		return kreditværdighed;
	}

	public void setKreditværdighed(char kreditværdighed) {
		this.kreditværdighed = kreditværdighed;
	}

	public String getRentesats() throws RentesatsIkkeUdfyldtException {
		if (rentesats.isEmpty())
			throw new RentesatsIkkeUdfyldtException();
		return rentesats;
	}

	public void setRentesats(String rentesats) {
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
}
