package kundeninfo;

public class Firmenkunde extends Kunde {

	private String referenz;

	public Firmenkunde(int kundennummer, String name, String benutzername, String passwort,
			Fuehrerschein fuehrerschein, Adresse adresse, Zahlungsmittel zahlungsmittel, String referenz) {
			super(kundennummer, name, benutzername, passwort, fuehrerschein, adresse, zahlungsmittel); 	
			this.referenz = referenz;
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
