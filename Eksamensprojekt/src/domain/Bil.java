package domain;

import exceptions.ModelIkkeOplystException;
import exceptions.PrisIkkeOplystException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.ÅrgangIkkeOplystException;
import exceptions.BilFindesIkkeException;

public interface Bil {
	
	public String getModel() throws ModelIkkeOplystException;
	public void setModel(String model);
	public String getStelNummer() throws StelnummerIkkeOplystException;
	public void setStelNummer(String stelNummer);
	public String getÅrgang() throws ÅrgangIkkeOplystException;
	public void setÅrgang(String årgang);
	public String getPris() throws PrisIkkeOplystException;
	public void setPris(String pris);
	public int getBilID() throws BilFindesIkkeException;
	public void setBilID(int bilID);
}
