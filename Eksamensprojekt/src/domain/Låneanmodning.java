package domain;

import exceptions.TelefonnummerIkkeOplystException;
import exceptions.PersonnummerIkkeUdfyldtException;
import exceptions.KreditværdighedIkkeUdfyldtException;
import exceptions.RentesatsIkkeUdfyldtException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.LøbetidIkkeUdfyldtException;

public interface Låneanmodning {
	public String getPersonNummer() throws PersonnummerIkkeUdfyldtException;

	public void setPersonNummer(String personNummer);

	public String getTelefonNummer() throws TelefonnummerIkkeOplystException;

	public void setTelefonNummer(String telefonNummer);

	public char getKreditværdihed() throws KreditværdighedIkkeUdfyldtException;

	public void setKreditværdighed(char kreditværdighed);

	public String getRentesats() throws RentesatsIkkeUdfyldtException;

	public void setRentesats(String rentesats);

	public String getStelNummer() throws StelnummerIkkeOplystException;

	public void setStelNummer(String stelNummer);

	public int getLøbetid() throws LøbetidIkkeUdfyldtException;

	public void setLøbetid(int løbetid);
}
