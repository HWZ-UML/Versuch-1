package kundeninfo;

public class Firmenkunde extends Kunde {

	private String referenz;

	public Firmenkunde(int kundennummer, String name, String benutzername, String passwort,
			Fuehrerschein fuehrerschein, Adresse adresse, Zahlungsmittel zahlungsmittel, String referenz) {//... alle Attribute von Kunde und Firmenkunden
	
			super(kundennummer, name, benutzername, passwort, fuehrerschein, adresse, zahlungsmittel); 	// .... für alle Kundenattribute
			this.referenz = referenz; // bei Subklassen nur für neues Attribut this. ..., da bei Kunde bereits angelegt
	}

	public String getReferenz() {
		return referenz;
	}

	public void setReferenz(String referenz) {
		this.referenz = referenz;
	}
	public Firmenkunde() {
	
	}
}
