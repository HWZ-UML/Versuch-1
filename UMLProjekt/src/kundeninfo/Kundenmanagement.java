package kundeninfo;

import java.util.HashMap;

public class Kundenmanagement {

	private HashMap<String, Kunde> kundenliste;

public Kundenmanagement() {
	kundenliste = new HashMap();	
}

	public Kunde getKunde(String benutzername) {
		return kundenliste.get(benutzername);
	}

	public int getSize() {
		return kundenliste.size(); // gibt Anz. Listenelemente zurück, wird für Kundennummer verwendet/ beginnt bei
								// 0
	}

	public void addKunde(Kunde kunde) {
		kundenliste.put(kunde.getBenutzername(), kunde); // fügt eîn bestehender Kunde der Liste hinzu / Kunde wird in Klasse Kunde erzeugt
	}
}
