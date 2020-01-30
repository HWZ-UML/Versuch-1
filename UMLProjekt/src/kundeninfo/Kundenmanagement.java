package kundeninfo;

import java.util.HashMap;
import java.util.Map.Entry;

import fahrzeuginfo.Auto;

public class Kundenmanagement {

	private HashMap<String, Kunde> kundenliste;

	public Kundenmanagement() {
		kundenliste = new HashMap();
	}

	public Kunde getKunde(String benutzername) {
		return kundenliste.get(benutzername);
	}

	public int getSize() {
		return kundenliste.size(); // gibt Anz. Listenelemente zur�ck, wird f�r Kundennummer verwendet/ beginnt bei 0
									
	}

	public void addKunde(Kunde kunde) {
		kundenliste.put(kunde.getBenutzername(), kunde); // f�gt e�n bestehender Kunde der Liste hinzu / Kunde wird in Start Klasse erzeugt
														
	}
	
	public HashMap<String, Kunde> getKundenliste() {
		return kundenliste;
	}

	public void druckeKundenangaben() {
		for (Entry<String, Kunde> e : kundenliste.entrySet()) {
			Kunde kunde = getKunde(e.getKey());
			System.out.println("Benutzername: " + kunde.getBenutzername() + "\n");
			System.out.println("Kundennummer: " + kunde.getKundennummer() + "\n");
		}
	}
}
