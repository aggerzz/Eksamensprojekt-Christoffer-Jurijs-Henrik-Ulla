package domain;

public class Sælger {

	private String forNavn;
	private String efterNavn;
	private int telefonNummer;
	private String email;
	public String getForNavn() {
		return forNavn;
	}
	public void setForNavn(String forNavn) {
		this.forNavn = forNavn;
	}
	public String getEfterNavn() {
		return efterNavn;
	}
	public void setEfterNavn(String efterNavn) {
		this.efterNavn = efterNavn;
	}
	public int getTelefonNummer() {
		return telefonNummer;
	}
	public void setTelefonNummer(int telefonNummer) {
		this.telefonNummer = telefonNummer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
