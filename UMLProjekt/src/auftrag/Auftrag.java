package auftrag;

import java.time.LocalDate;
import enums.Auftragsstatus;
import fahrzeuginfo.Auto;

public class Auftrag {

	private int auftragsnummer;
	private String auftragsdatum;
	private int kundennummer;
	// private Kunde kundennummer;
	private int autonummer;
	public Auto auto;
	private LocalDate datumVon;
	private LocalDate datumBis;
	private String startOrt;
	private String zielOrt;
	private String einsatzgebiet = "Schweiz";
	private Auftragsstatus auftragsstatus = Auftragsstatus.inPruefung;
	private int mietdauer;

	public int getAuftragsnummer() {
		return auftragsnummer;
	}

	public String getAuftragsdatum() {
		return auftragsdatum;
	}

	public int getKundennummer() {
		return kundennummer;
	}

	public int getAutonummer() {
		return autonummer;
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

	public void setAuftragsnummer(int auftragsnummer) {
		this.auftragsnummer = auftragsnummer;
	}

	public void setAuftragsdatum(String auftragsdatum) {
		this.auftragsdatum = auftragsdatum;
	}

	public void setKundennummer(int kundennummer) {
		this.kundennummer = kundennummer;
	}

	public void setAutonummer(int autonummer) {
		this.autonummer = autonummer;
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
	
	public Auftrag (int auftragsnummer, String auftragsdatum, int kundennummer, int autonummer, Auto auto, LocalDate datumVon, LocalDate datumBis, 
			String startOrt, String zielOrt, String einsatzgebiet, Auftragsstatus auftragsstatus, int mietdauer) {
		this.auftragsnummer = auftragsnummer;
		this.auftragsdatum = auftragsdatum;
		this.kundennummer = kundennummer;
		this.autonummer = autonummer;
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
