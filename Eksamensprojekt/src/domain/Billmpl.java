package domain;

public class Billmpl {

	private String model;
	private String stelNummer;
	private String årgang;
	private int bilID;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getStelNummer() {
		return stelNummer;
	}
	public void setStelNummer(String stelNummer) {
		this.stelNummer = stelNummer;
	}
	public String getÅrgang() {
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
