package domain;

import exceptions.ModelIkkeOplystException;
import exceptions.StelnummerIkkeOplystException;
import exceptions.ÅrgangIkkeOplystException;
import exceptions.BilFindesIkkeException;

public class Billmpl implements Bil {

	private String model;
	private String stelNummer;
	private String årgang;
	private int bilID;
	
	public String getModel() throws ModelIkkeOplystException {
		if(model.isEmpty())
			throw new ModelIkkeOplystException();
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getStelNummer() throws StelnummerIkkeOplystException {
		if(stelNummer.isEmpty())
			throw new StelnummerIkkeOplystException();
		return stelNummer;
	}
	public void setStelNummer(String stelNummer) {
		this.stelNummer = stelNummer;
	}
	public String getÅrgang() throws ÅrgangIkkeOplystException {
		if(årgang.isEmpty())
			throw new ÅrgangIkkeOplystException();
		return årgang;
	}
	public void setÅrgang(String årgang) {
		this.årgang = årgang;
	}
	public int getBilID() throws BilFindesIkkeException{
		if(årgang.isEmpty())
			throw new BilFindesIkkeException();
		return bilID;
	}
	public void setBilID(int bilID) {
		this.bilID = bilID;
	}
}
