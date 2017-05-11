package domain;

import exceptions.MangledeInformationOmSælgerException;;

public class Sælgerlmpl {

	private String login;
	private String adgangskode;
	private String forNavn;
	private String efterNavn;
	private String telefonNummer;
	private String email;
	private int id;
	
	public String getForNavn() throws MangledeInformationOmSælgerException {
		if(forNavn.isEmpty())
			throw new MangledeInformationOmSælgerException();
		return forNavn;
	}
	public void setForNavn(String forNavn) {
		this.forNavn = forNavn;
	}
	public String getEfterNavn() throws MangledeInformationOmSælgerException {
		if(efterNavn.isEmpty())
			throw new MangledeInformationOmSælgerException();
		return efterNavn;
	}
	public void setEfterNavn(String efterNavn) {
		this.efterNavn = efterNavn;
	}
	public String getTelefonNummer() throws MangledeInformationOmSælgerException {
		if(telefonNummer.isEmpty())
			throw new MangledeInformationOmSælgerException();
		return telefonNummer;
	}
	public void setTelefonNummer(String telefonNummer) {
		this.telefonNummer = telefonNummer;
	}
	public String getEmail() throws MangledeInformationOmSælgerException {
		if(email.isEmpty())
			throw new MangledeInformationOmSælgerException();
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() throws MangledeInformationOmSælgerException {
		if(login.isEmpty())
			throw new MangledeInformationOmSælgerException();
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getAdgangskode() throws MangledeInformationOmSælgerException {
		if(adgangskode.isEmpty())
			throw new MangledeInformationOmSælgerException();
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
