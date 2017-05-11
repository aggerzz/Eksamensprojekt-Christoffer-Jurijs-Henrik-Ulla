package domain;

import exceptions.MangledeInformationOmKundenException;

public interface Kunde {
	
	public String getForNavn() throws MangledeInformationOmKundenException;
	public void setForNavn(String forNavn);
	public String getEfterNavn() throws MangledeInformationOmKundenException;
	public void setEfterNavn(String efterNavn);
	public String getAdresse() throws MangledeInformationOmKundenException;
	public void setAdresse(String adresse);
	public String getPostNummer() throws MangledeInformationOmKundenException;
	public void setPostNummer(String postNummer);
	public String getBy() throws MangledeInformationOmKundenException;
	public void setBy(String by);
	public String getFodselsdato() throws MangledeInformationOmKundenException;
	public void setFodselsdato(String fodselsdato);
	public String getTelefonNummer() throws MangledeInformationOmKundenException;
	public void setTelefonNummer(String telefonNummer);
	public String getEmail() throws MangledeInformationOmKundenException;
	public void setEmail(String email);
}