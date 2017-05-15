package domain;

import exceptions.AdresseIkkeOplystException;
import exceptions.ByIkkeOplystException;
import exceptions.EfternavnIkkeOplystException;
import exceptions.EmailIkkeOplystException;
import exceptions.FodselsdagIkkeOplystException;
import exceptions.FornavnIkkeOplystException;
import exceptions.PostnummerIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;

public interface Kunde {
	
	public String getForNavn() throws FornavnIkkeOplystException;
	public void setForNavn(String forNavn);
	public String getEfterNavn() throws EfternavnIkkeOplystException;
	public void setEfterNavn(String efterNavn);
	public String getAdresse() throws AdresseIkkeOplystException;
	public void setAdresse(String adresse);
	public String getPostNummer() throws PostnummerIkkeOplystException;
	public void setPostNummer(String postNummer);
	public String getBy() throws ByIkkeOplystException;
	public void setBy(String by);
	public String getFodselsdato() throws FodselsdagIkkeOplystException;
	public void setFodselsdato(String fodselsdato);
	public String getTelefonNummer() throws TelefonnummerIkkeOplystException;
	public void setTelefonNummer(String telefonNummer);
	public String getEmail() throws EmailIkkeOplystException;
	public void setEmail(String email);
}