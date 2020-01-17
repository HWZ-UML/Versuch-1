package auftrag;

import java.util.HashMap;

import fahrzeuginfo.Auto;

public class Auftragsmanagement {

		private HashMap<Integer, Auftrag> auftragsliste;

	public Auftragsmanagement() {
		auftragsliste = new HashMap();	
	}
		public int getSize() {
			return auftragsliste.size(); // gibt Anz. Listenelemente zurück, wird für Kundennummer verwendet/ beginnt bei 0
								
		}
		
		public Auftrag getAuftrag(int auftragsnummer) {
			return auftragsliste.get(auftragsnummer);
			
		}

		public void addAuftrag(Auftrag auftrag) {
			auftragsliste.put(auftrag.getAuftragsnummer(), auftrag); // fügt eîn bestehender Kunde der Liste hinzu / Kunde wird in Klasse  Start erzeugt
		}
}
