package kundeninfo;

public class Adresse {

	private String strasse;
	private int hausnummer;
	private int postleitzahl;
	private String ort;
	private String email;
	private long telefon;

	public Adresse(String strasse, int hausnummer, int postleitzahl, String ort, String email, long telefon) {
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.postleitzahl = postleitzahl;
		this.ort = ort;
		this.email = email;
		this.telefon = telefon;
	}

	public String getStrasse() {
		return strasse;
	}

	public int getHausnummer() {
		return hausnummer;
	}

	public int getPostleitzahl() {
		return postleitzahl;
	}

	public String getOrt() {
		return ort;
	}

	public String getEmail() {
		return email;
	}

	public long getTelefon() {
		return telefon;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}

	public void setPostleitzahl(int postleitzahl) {
		this.postleitzahl = postleitzahl;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefon(long telefon) {
		this.telefon = telefon;
	}

public Adresse() {
	
}
}
