package domain;

import exceptions.AdgangskodeIkkeOplystException;
import exceptions.BrugernavnIkkeOplystException;
import exceptions.EfternavnIkkeOplystException;
import exceptions.EmailIkkeOplystException;
import exceptions.FornavnIkkeOplystException;
import exceptions.TelefonnummerIkkeOplystException;

public interface Sælger {
	
	public String getForNavn() throws FornavnIkkeOplystException;
	public void setForNavn(String forNavn);
	public String getEfterNavn() throws EfternavnIkkeOplystException;
	public void setEfterNavn(String efterNavn);
	public String getTelefonNummer() throws TelefonnummerIkkeOplystException;
	public void setTelefonNummer(String telefonNummer);
	public String getEmail() throws EmailIkkeOplystException;
	public void setEmail(String email);
	public String getLogin() throws BrugernavnIkkeOplystException;
	public void setLogin(String login);
	public String getAdgangskode() throws AdgangskodeIkkeOplystException;
	public void setAdgangskode(String adgangskode);
	public int getId();
	public void setId(int id);
}
