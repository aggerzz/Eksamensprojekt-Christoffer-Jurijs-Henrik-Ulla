package domain;

public class Bil {

	private String model;
	private int stelNummer;
	private int årgang;
	private int bilID;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSetlNummer() {
		return stelNummer;
	}
	public void setSetlNummer(int setlNummer) {
		this.stelNummer = setlNummer;
	}
	public int getÅrgang() {
		return årgang;
	}
	public void setÅrgang(int årgang) {
		this.årgang = årgang;
	}
	public int getBilID() {
		return bilID;
	}
	public void setBilID(int bilID) {
		this.bilID = bilID;
	}
}
