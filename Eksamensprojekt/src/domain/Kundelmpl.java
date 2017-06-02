package domain;

import exceptions.AdresseIkkeOplystException;
import exceptions.ByIkkeOplystException;
import exceptions.EfternavnIkkeOplystException;
import exceptions.EmailIkkeOplystException;
import exceptions.FodselsdagIkkeOplystException;
import exceptions.FornavnIkkeOplystException;
import exceptions.PostnummerIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;

public class Kundelmpl implements Kunde {

	private String forNavn;
	private String efterNavn;
	private String adresse;
	private String postNummer;
	private String by;
	private String fodselsdato;
	private String telefonNummer;
	private String email;

	public String getForNavn() throws FornavnIkkeOplystException {
		// if(forNavn.isEmpty())
		// throw new FornavnIkkeOplystException();
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

	public String getAdresse() throws AdresseIkkeOplystException {
		if (adresse.isEmpty())
			throw new AdresseIkkeOplystException();
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPostNummer() throws PostnummerIkkeOplystException {
		if (postNummer.isEmpty())
			throw new PostnummerIkkeOplystException();
		return postNummer;
	}

	public void setPostNummer(String postNummer) {
		this.postNummer = postNummer;
	}

	public String getBy() throws ByIkkeOplystException {
		if (by.isEmpty())
			throw new ByIkkeOplystException();
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public String getFodselsdato() throws FodselsdagIkkeOplystException {
		if (fodselsdato.isEmpty())
			throw new FodselsdagIkkeOplystException();
		return fodselsdato;
	}

	public void setFodselsdato(String fodselsdato) {
		this.fodselsdato = fodselsdato;
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

	@Override
	public void add(Kunde findkunde) {

	}
}
