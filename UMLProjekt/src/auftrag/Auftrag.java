package auftrag;

import java.time.LocalDate;
import enums.Auftragsstatus;
import fahrzeuginfo.Auto;

public class Auftrag {

	private int auftragsnummer;
	private String auftragsdatum;
	private int kundennummer;
	private Auto auto;
	private LocalDate datumVon;
	private LocalDate datumBis;
	private String startOrt;
	private String zielOrt;
	private String einsatzgebiet = "Schweiz";
	private Auftragsstatus auftragsstatus = Auftragsstatus.inPruefung;
	private int mietdauer;
	private boolean AntwortKreditkartenAnbieter = false;
	private Auto status;

	public int getAuftragsnummer() {
		return auftragsnummer;
	}

	public String getAuftragsdatum() {
		return auftragsdatum;
	}

	public int getKundennummer() {
		return kundennummer;
	}

	public LocalDate getDatumVon() {
		return datumVon;
	}

	public LocalDate getDatumBis() {
		return datumBis;
	}

	public String getStartOrt() {
		return startOrt;
	}

	public String getZielOrt() {
		return zielOrt;
	}

	public String getEinsatzgebiet() {
		return einsatzgebiet;
	}

	public Auftragsstatus getAuftragsstatus() {
		return auftragsstatus;
	}

	public int getMietdauer() {
		return mietdauer;
	}

	public Auto getAuto() {
		return auto;
	}
	
	public Boolean getAntwortKreditkartenAnbieter() {
		return AntwortKreditkartenAnbieter;
	}
	
	public Auto getStatus() {
		return status;
	}

	public void setAuftragsnummer(int auftragsnummer) {
		this.auftragsnummer = auftragsnummer;
	}

	public void setAuftragsdatum(String auftragsdatum) {
		this.auftragsdatum = auftragsdatum;
	}

	public void setKundennummer(int kundennummer) {
		this.kundennummer = kundennummer;
	}

	public void setDatumVon(LocalDate datumVon) {
		this.datumVon = datumVon;
	}

	public void setDatumBis(LocalDate datumBis) {
		this.datumBis = datumBis;
	}

	public void setStartOrt(String startOrt) {
		this.startOrt = startOrt;
	}

	public void setZielOrt(String zielOrt) {
		this.zielOrt = zielOrt;
	}

	public void setEinsatzgebiet(String einsatzgebiet) {
		this.einsatzgebiet = einsatzgebiet;
	}

	public void setAuftragstatus(Auftragsstatus status) {
		this.auftragsstatus = status;
	}

	public void setMietdauer(int mietdauer) {
		this.mietdauer = mietdauer;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	
	public void setAntwortKreditkartenAnbieter( Boolean antwortKreditkartenAnbieter) {
		this.AntwortKreditkartenAnbieter = antwortKreditkartenAnbieter;
	}
	
	public void setStatus(Auto status) {
		this.status = status;
	}
	
	public Auftrag (int auftragsnummer, String auftragsdatum, int kundennummer, Auto auto, LocalDate datumVon, LocalDate datumBis, 
			String startOrt, String zielOrt, String einsatzgebiet, Auftragsstatus auftragsstatus, int mietdauer) {
		this.auftragsnummer = auftragsnummer;
		this.auftragsdatum = auftragsdatum;
		this.kundennummer = kundennummer;
		this.auto = auto;
		this.datumVon = datumVon;
		this.datumBis = datumBis;
		this.startOrt = startOrt;
		this.zielOrt = zielOrt;
		this.einsatzgebiet = einsatzgebiet;
		this.auftragsstatus = auftragsstatus;
		this.mietdauer = mietdauer;
	}

	public Auftrag() {
	}
	

}
