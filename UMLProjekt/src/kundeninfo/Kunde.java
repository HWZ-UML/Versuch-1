package kundeninfo;

public class Kunde {

	private int kundennummer;
	private String name;
	private String benutzername;
	private String passwort;
	private double umsatz = 0;
	private boolean gesperrt = false;
	private boolean login = false;
	private Fuehrerschein fuehrerschein;
	private Adresse adresse;
	private Zahlungsmittel zahlungsmittel;
	
	public int getKundennummer() {
		return kundennummer;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBenutzername() {
		return benutzername;
	}
	
	public String getPasswort() {
		return passwort;
	}
	
	public double getUmsatz() {
		return umsatz;
	}
	
	public boolean getGesperrt() {
		return gesperrt;
	}
	
	public boolean getLogin() {
		return login;
	}
	
	public Fuehrerschein getFuehrerschein() {
		return fuehrerschein;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}
	
	public Zahlungsmittel getZahlungsmittel() {
		return zahlungsmittel;
	}
	
	public void setKundenummer(int kundenummer) {
		this.kundennummer = kundenummer;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	
	public void setUmsatz(int umsatz) {
		this.umsatz = umsatz;
	}
	
	public void setGesperrt(boolean gesperrt) {
		this.gesperrt = gesperrt;
	}
	
	public void setLogin(boolean login) {
		this.login = login;
	}
	
	public void setFuehrerschein(Fuehrerschein fuehrerschein) {
		this.fuehrerschein = fuehrerschein;
	}
	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public void setZahlungsmittel(Zahlungsmittel zahlungsmittel) {
		this.zahlungsmittel = zahlungsmittel;
	}
	
	public Kunde(int Kudennummer, String name, String benutzername, String passwort, Fuehrerschein fuehrerschein, 
		Adresse adresse, Zahlungsmittel zahlungsmittel) { 
		this.name = name;
		this.benutzername = benutzername;
		this.passwort = passwort;
		this.fuehrerschein = fuehrerschein;
		this.adresse = adresse;
		this.zahlungsmittel = zahlungsmittel;
	}

	public Kunde() {
	
	}


	
}

