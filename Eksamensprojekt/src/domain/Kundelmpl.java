package domain;

import exceptions.MangledeInformationOmKundenException;

public class Kundelmpl implements Kunde {

	private String forNavn;
	private String efterNavn;
	private String adresse;
	private String postNummer;
	private String by;
	private String fodselsdato;
	private String telefonNummer;
	private String email;
	
	public String getForNavn() throws MangledeInformationOmKundenException {
		if(forNavn.isEmpty())
			throw new MangledeInformationOmKundenException();
		return forNavn;
	}
	public void setForNavn(String forNavn) {
		this.forNavn = forNavn;
	}
	public String getEfterNavn() throws MangledeInformationOmKundenException {
		if(efterNavn.isEmpty())
			throw new MangledeInformationOmKundenException();
		return efterNavn;
	}
	public void setEfterNavn(String efterNavn) {
		this.efterNavn = efterNavn;
	}
	public String getAdresse() throws MangledeInformationOmKundenException {
		if(adresse.isEmpty())
			throw new MangledeInformationOmKundenException();
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPostNummer() throws MangledeInformationOmKundenException {
		if(postNummer.isEmpty())
			throw new MangledeInformationOmKundenException();
		return postNummer;
	}
	public void setPostNummer(String postNummer) {
		this.postNummer = postNummer;
	}
	public String getBy() throws MangledeInformationOmKundenException {
		if(by.isEmpty())
			throw new MangledeInformationOmKundenException();
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	public String getFodselsdato() throws MangledeInformationOmKundenException {
		if(fodselsdato.isEmpty())
			throw new MangledeInformationOmKundenException();
		return fodselsdato;
	}
	public void setFodselsdato(String fodselsdato) {
		this.fodselsdato = fodselsdato;
	}
	public String getTelefonNummer() throws MangledeInformationOmKundenException {
		if(telefonNummer.isEmpty())
			throw new MangledeInformationOmKundenException();
		return telefonNummer;
	}
	public void setTelefonNummer(String telefonNummer) {
		this.telefonNummer = telefonNummer;
	}
	public String getEmail() throws MangledeInformationOmKundenException {
		if(email.isEmpty())
			throw new MangledeInformationOmKundenException();
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
