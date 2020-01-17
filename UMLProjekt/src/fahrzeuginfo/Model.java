package fahrzeuginfo;

import enums.Fahrzeugklasse;
import enums.Marke;
import enums.Treibstoff;

public class Model {

	private String modelName;
	private Fahrzeugklasse fahrzeugklasse;
	private Marke marke;
	private Treibstoff treibstoff;
	private int anzahlSitzplaetze;
	private double modelPreis;
	private double fixZuschlag = 75.00;
	private double mwst = 7.70;
	
	public String getModelName() {
		return modelName;
	}
	
	public Fahrzeugklasse getFahrzeugklasse() {
		return fahrzeugklasse;
	}
	
	public Marke getMarke() {
		return marke;
	}
	
	public Treibstoff getTreibstoff() {
		return treibstoff;
	}
	
	public int getAnzahlSitzplaetze() {
		return anzahlSitzplaetze;
	}
	
	public double getModelPreis() {
		return modelPreis;
	}
	
	public double getFixZuschlag() {
		return fixZuschlag;
	}
	
	public double getMwst() {
		return mwst;
	}
	
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	public void setFahrzeugklasse(Fahrzeugklasse fahrzeugklasse) {
		this.fahrzeugklasse = fahrzeugklasse;
	}
	
	public void setMarke(Marke marke) {
		this.marke = marke;
	}
	
	public void setTreibstoff(Treibstoff treibstoff) {
		this.treibstoff = treibstoff;
	}
	
	public void setAnzahlSitzplaetze(int anzahlSitzplaetze) {
		this.anzahlSitzplaetze = anzahlSitzplaetze;
	}
	
	public void setModelPreis(double modelPreis) {
		this.modelPreis = modelPreis;
	}
	
	public void setFixZuschlag(double fixZuschlag) {
		this.fixZuschlag = fixZuschlag;
	}
	
	public void setMwst(double mwst) {
		this.mwst = mwst;
	}
	
	public Model() {
		
	}
	public Model(String modelName, Fahrzeugklasse fahrzeugklasse, Marke marke, Treibstoff treibstoff, int anzahlSitzplatze, double preis) {
		
	}
}
