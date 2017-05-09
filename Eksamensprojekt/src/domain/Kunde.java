package domain;

public class Kunde {

	private String forNavn;
	private String efterNAvn;
	private String adresse;
	private int postNummer;
	private String by;
	private String fodselsdato;
	private int telefonNummer;
	private String email;
	public String getForNavn() {
		return forNavn;
	}
	public void setForNavn(String forNavn) {
		this.forNavn = forNavn;
	}
	public String getEfterNAvn() {
		return efterNAvn;
	}
	public void setEfterNAvn(String efterNAvn) {
		this.efterNAvn = efterNAvn;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getPostNummer() {
		return postNummer;
	}
	public void setPostNummer(int postNummer) {
		this.postNummer = postNummer;
	}
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	public String getFodselsdato() {
		return fodselsdato;
	}
	public void setFodselsdato(String fodselsdato) {
		this.fodselsdato = fodselsdato;
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
