package kundeninfo;

import java.time.LocalDate;

public class Privatkunde extends Kunde{ 

	private String vorname;
	private LocalDate geburtsdatum;
	
	public String getVorname() {
		return vorname;
	}
	
	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public void setGeburtsdatum(LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	
	public Privatkunde(int kundennummer, String name, String benutzername, 
			String passwort, Fuehrerschein fuehrerschein, 
			Adresse adresse, Zahlungsmittel zahlungsmittel, 
			String vorname, LocalDate geburtsdatum) {
		
		super(kundennummer, name, benutzername, passwort, fuehrerschein, adresse, zahlungsmittel);
	
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
		
	}
	
	public Privatkunde() {
	}
	

	}
	
	


	


