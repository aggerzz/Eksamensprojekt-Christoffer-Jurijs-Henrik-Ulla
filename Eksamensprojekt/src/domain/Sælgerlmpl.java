package domain;

public class Sælgerlmpl {

	private String login;
	private String adgangskode;
	private String forNavn;
	private String efterNavn;
	private String telefonNummer;
	private String email;
	private int id;
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
	public String getTelefonNummer() {
		return telefonNummer;
	}
	public void setTelefonNummer(String telefonNummer) {
		this.telefonNummer = telefonNummer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getAdgangskode() {
		return adgangskode;
	}
	public void setAdgangskode(String adgangskode) {
		this.adgangskode = adgangskode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
