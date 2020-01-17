	package auftrag;
	import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

	import enums.Auftragsstatus;
	import fahrzeuginfo.Auto;
	import kundeninfo.Kunde;

	public class Auftrag {

		private int auftragsnummer;
		private String auftragsdatum;
		private int kundennummer;
		//private Kunde kundennummer;
		private int autonummer;
		//private Auto fahrzeugnummer;
		private LocalDate datumVon;
		private LocalDate datumBis;
		private String startOrt;
		private String zielOrt;
		private String einsatzgebiet = "Schweiz";
		private Auftragsstatus auftragsstatus = Auftragsstatus.inPruefung;
		
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
		
	}

