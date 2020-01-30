package fahrzeuginfo;

import java.util.HashMap;
import java.util.Map.Entry;

public class Automanagement {

	private HashMap<Integer, Auto> autoliste;

	public Automanagement() {
		autoliste = new HashMap();
	}

	public int getSize() {
		return autoliste.size(); // gibt Anz. Listenelemente zurück, wird für Autonummer verwendet/ beginnt bei 0
								
	}

	public Auto getAuto(int fahrzeugnummer) {
		return autoliste.get(fahrzeugnummer);

	}

	public void addAuto(Auto auto) {
		autoliste.put(auto.getFahrzeugnummer(), auto); // fügt eîn Auto der Liste hinzu / Auto wird in der Klasse Start erzeugt
														
	}

	public HashMap<Integer, Auto> getAutoliste() {
		return autoliste;
	}

	public void druckAutoliste() {
		for (Entry<Integer, Auto> e : autoliste.entrySet()) {
			Auto auto = getAuto(Integer.parseInt(e.getKey().toString()));
			Model model = auto.getModel();
			System.out.println("Fahrzeugnummer: " + auto.getFahrzeugnummer() + "\n");
			System.out.println("Kennzeichen: " + auto.getKennzeichen() + "\n");
			System.out.println("Kilometerstand: " + auto.getKilometerstand() + "\n");
			System.out.println("Zulassung: " + auto.getKilometerstand() + "\n");
			System.out.println("Model: " + model.getModelName() + "\n");
			System.out.println("Fahrzeugklasse: " + model.getFahrzeugklasse() + "\n");
			System.out.println("Marke: " + model.getMarke() + "\n");
			System.out.println("Treibstoff: " + model.getTreibstoff() + "\n");
			System.out.println("Anzahl Sitzplätze: " + model.getAnzahlSitzplaetze() + "\n");
			System.out.println("Preis pro Tag inkl. MWST und Fixkosten von CHF 75.- : " + model.getModelPreis() + "\n");
			System.out.println("Farbe: " + auto.getFarbe() + "\n" + "\n");
		}
	}

}
