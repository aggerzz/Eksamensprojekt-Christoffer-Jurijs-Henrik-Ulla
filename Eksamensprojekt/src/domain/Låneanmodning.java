package domain;

import exceptions.TelefonnummerIkkeOplystException;
import exceptions.PersonnummerIkkeUdfyldtException;
import exceptions.KreditværdighedIkkeUdfyldtException;
import exceptions.RentesatsIkkeUdfyldtException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.LøbetidIkkeUdfyldtException;

public interface Låneanmodning {
	public double getPris() throws Exception;
	public void setPris(double pris);
	public String getPersonNummer() throws PersonnummerIkkeUdfyldtException;

	public void setPersonNummer(String personNummer);

	public String getTelefonNummer() throws TelefonnummerIkkeOplystException;

	public void setTelefonNummer(String telefonNummer);

	public char getKreditværdighed() throws KreditværdighedIkkeUdfyldtException;

	public void setKreditværdighed(char kreditværdighed);

	public double getRentesats() throws RentesatsIkkeUdfyldtException;

	public void setRentesats(double rentesats);

	public String getStelNummer() throws StelnummerIkkeOplystException;

	public void setStelNummer(String stelNummer);

	public int getLøbetid() throws LøbetidIkkeUdfyldtException;

	public void setLøbetid(int løbetid);
	
	public double getUdbetaling() throws LøbetidIkkeUdfyldtException;

	public void setUdbetaling(double udbetaling);

}
