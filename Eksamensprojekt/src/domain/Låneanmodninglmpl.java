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
	private String kreditværdighed;
	private String rentesats;
	private String stelNummer;
	private String løbetid;

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

	public String getKreditværdihed() throws KreditværdighedIkkeUdfyldtException {
		if (kreditværdighed.isEmpty())
			throw new KreditværdighedIkkeUdfyldtException();
		return kreditværdighed;
	}

	public void setKreditværdighed(String kreditværdighed) {
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

	public String getLøbetid() throws LøbetidIkkeUdfyldtException {
		if (løbetid.isEmpty())
			throw new LøbetidIkkeUdfyldtException();
		return løbetid;
	}

	public void setLøbetid(String løbetid) {
		this.løbetid = løbetid;
	}
}
