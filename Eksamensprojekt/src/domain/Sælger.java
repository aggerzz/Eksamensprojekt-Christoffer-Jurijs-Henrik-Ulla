package domain;

import exceptions.MangledeInformationOmSælgerException;

public interface Sælger {
	
	public String getForNavn() throws MangledeInformationOmSælgerException;
	public void setForNavn(String forNavn);
	public String getEfterNavn() throws MangledeInformationOmSælgerException;
	public void setEfterNavn(String efterNavn);
	public String getTelefonNummer() throws MangledeInformationOmSælgerException;
	public void setTelefonNummer(String telefonNummer);
	public String getEmail() throws MangledeInformationOmSælgerException;
	public void setEmail(String email);
	public String getLogin() throws MangledeInformationOmSælgerException;
	public void setLogin(String login);
	public String getAdgangskode() throws MangledeInformationOmSælgerException;
	public void setAdgangskode(String adgangskode);
	public int getId();
	public void setId(int id);
}
