package domain;

import exceptions.MangledeInformationOmBilenException;

public interface Bil {
	
	public String getModel() throws MangledeInformationOmBilenException;
	public void setModel(String model);
	public String getStelNummer() throws MangledeInformationOmBilenException;
	public void setStelNummer(String stelNummer);
	public String getÅrgang() throws MangledeInformationOmBilenException;
	public void setÅrgang(String årgang);
	public int getBilID() throws MangledeInformationOmBilenException;
	public void setBilID(int bilID);
}
