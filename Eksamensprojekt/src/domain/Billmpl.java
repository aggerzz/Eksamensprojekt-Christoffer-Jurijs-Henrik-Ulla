package domain;

import exceptions.MangledeInformationOmBilenException;;

public class Billmpl implements Bil {

	private String model;
	private String stelNummer;
	private String årgang;
	private int bilID;
	
	public String getModel() throws MangledeInformationOmBilenException {
		if(model.isEmpty())
			throw new MangledeInformationOmBilenException();
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getStelNummer() throws MangledeInformationOmBilenException {
		if(stelNummer.isEmpty())
			throw new MangledeInformationOmBilenException();
		return stelNummer;
	}
	public void setStelNummer(String stelNummer) {
		this.stelNummer = stelNummer;
	}
	public String getÅrgang() throws MangledeInformationOmBilenException {
		if(årgang.isEmpty())
			throw new MangledeInformationOmBilenException();
		return årgang;
	}
	public void setÅrgang(String årgang) {
		this.årgang = årgang;
	}
	public int getBilID() {
		return bilID;
	}
	public void setBilID(int bilID) {
		this.bilID = bilID;
	}
}
