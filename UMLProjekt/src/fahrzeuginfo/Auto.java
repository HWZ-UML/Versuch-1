package fahrzeuginfo;
import java.time.LocalDate;
import java.util.Set;

import enums.Farbe;
import enums.Status;

public class Auto {  

	private int fahrzeugnummer;
	private String kennzeichen;
	private int kilometerstand;
	private LocalDate zulassung;
	private Model model;
	private Status status = Status.verfuegbar;
	private Farbe farbe;

	public int getFahrzeugnummer() {
		return fahrzeugnummer;
	}
	
	public String getKennzeichen() {
		return kennzeichen;
	}
	
	public int getKilometerstand() {
		return kilometerstand;
	}
	
	public LocalDate getZulassung() {
		return zulassung;
	}
	
	public Model getModel() {
		return model;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public Farbe getFarbe() {
		return farbe;
	}
	
	public void setFahrzeugnummer(int fahrzeugnummer) {
		this.fahrzeugnummer = fahrzeugnummer;
	}
	
	public void setKennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}
	
	public void setKilometerstand(int kilometerstand) {
		this.kilometerstand = kilometerstand;
	}
	
	public void setZulassung(LocalDate zulassung) {
		this.zulassung = zulassung;
	}
	
	public void setModel(Model model) {
		this.model = model;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void setFarbe(Farbe farbe) {
		this.farbe = farbe;
	}
	
	public Auto() {
		
	}
	
	public Auto(int fahrzeugnummer, String kennzeichen, int kilometerstand, LocalDate Zulassung, Model model, Status status, Farbe farbe) {
		this.fahrzeugnummer = fahrzeugnummer;
		this.kennzeichen = kennzeichen;
		this.kilometerstand = kilometerstand;
		this.zulassung = zulassung;
		this.model = model;
		this.status = status;
		this.farbe = farbe;
	}
}

