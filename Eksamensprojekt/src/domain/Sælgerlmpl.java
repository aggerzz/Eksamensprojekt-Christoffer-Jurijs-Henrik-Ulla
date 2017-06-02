package domain;

import exceptions.AdgangskodeIkkeOplystException;
import exceptions.BrugernavnIkkeOplystException;
import exceptions.EfternavnIkkeOplystException;
import exceptions.EmailIkkeOplystException;
import exceptions.FornavnIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;

public class Sælgerlmpl implements Sælger {

	private String login;
	private String adgangskode;
	private String forNavn;
	private String efterNavn;
	private String telefonNummer;
	private String email;
	private int id;

	public String getForNavn() throws FornavnIkkeOplystException {
		if (forNavn.isEmpty())
			throw new FornavnIkkeOplystException();
		return forNavn;
	}

	public void setForNavn(String forNavn) {
		this.forNavn = forNavn;
	}

	public String getEfterNavn() throws EfternavnIkkeOplystException {
		if (efterNavn.isEmpty())
			throw new EfternavnIkkeOplystException();
		return efterNavn;
	}

	public void setEfterNavn(String efterNavn) {
		this.efterNavn = efterNavn;
	}

	public String getTelefonNummer() throws TelefonnummerIkkeOplystException {
		if (telefonNummer.isEmpty())
			throw new TelefonnummerIkkeOplystException();
		return telefonNummer;
	}

	public void setTelefonNummer(String telefonNummer) {
		this.telefonNummer = telefonNummer;
	}

	public String getEmail() throws EmailIkkeOplystException {
		if (email.isEmpty())
			throw new EmailIkkeOplystException();
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() throws BrugernavnIkkeOplystException {
		if (login.isEmpty())
			throw new BrugernavnIkkeOplystException();
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAdgangskode() throws AdgangskodeIkkeOplystException {
		if (adgangskode.isEmpty())
			throw new AdgangskodeIkkeOplystException();
		return adgangskode;
	}

	public void setAdgangskode(String adgangskode) {
		this.adgangskode = adgangskode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
