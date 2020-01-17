package fahrzeuginfo;

import java.util.ArrayList;

public class Automanagement {

		private ArrayList<Auto> autoliste;

	public Automanagement() {
		ArrayList<Auto> autoliste = new ArrayList<Auto>();	
	}
		public int getSize() {
		return autoliste.size(); // gibt Anz. Listenelemente zurück, wird für Kundennummer verwendet/ beginnt bei
									// 0
		}
		
		public Auto getAuto(int fahrzeugnummer) {
			return autoliste.get(fahrzeugnummer);
			
		}

		public void addAuto(Auto auto) {
			autoliste.add(auto); // fügt eîn bestehendes Auto der Liste hinzu / Auto wird in Klasse Kunde erzeugt
		}
		
		public void druckAutoliste() {
			System.out.println(autoliste.toString());
		}

	//	public void druckAutoliste() {
		//for(int key : autoliste.keySet()) {
			
			//System.out.println("Key: " + key + " / " + "Value: " + autoliste.get(key));
		//}		
	}


