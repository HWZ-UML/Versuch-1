package auftrag;

import java.util.HashMap;
import java.util.Map.Entry;

import fahrzeuginfo.*;

public class Auftragsmanagement {

	private HashMap<Integer, Auftrag> auftragsliste;

	public Auftragsmanagement() {
		auftragsliste = new HashMap();
	}

	public int getSize() {
		return auftragsliste.size(); // gibt Anz. Listenelemente zurück, wird für Auftragsnummer verwendet/ beginnt bei 0

	}

	public Auftrag getAuftrag(int auftragsnummer) {
		return auftragsliste.get(auftragsnummer);

	}

	public void addAuftrag(Auftrag auftrag) {
		auftragsliste.put(auftrag.getAuftragsnummer(), auftrag); // fügt eîn Auftrag der Liste hinzu / Auftrag wird in Klasse Start erzeugt
																
	}
	
	public HashMap<Integer, Auftrag> getAuftragsliste() {
		return auftragsliste;
	}

	public void druckeAuftrag() {
		for (Entry<Integer, Auftrag> e : auftragsliste.entrySet()) {
			Auftrag auftrag = getAuftrag(e.getKey());
			Auto auto = auftrag.getAuto();
			Model model = auto.getModel();
			System.out.println("Auftragsnummer: " + auftrag.getAuftragsnummer() + "\n");
			System.out.println("Mietdauer: " + auftrag.getDatumVon() + " - " + auftrag.getDatumBis() + "\n");
			System.out.println("Preis: " + auftrag.getMietdauer() * model.getModelPreis());
		}

	}
}
