
package start;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//****************************************
//
//Class um einen String (ein Word) im .txt zu Überprüfen. Die Prüfung erfolgt per Linie. Ende von der Methode ist jeweils der Code zum Aufrufen der Methode und die Varibeln, welche gestetz werde müssen.
//
//****************************************
class Textfilereader {

	private Boolean found = null; // wird auf true oder false geändert wenn der text vorhanden ist = true, wenn
									//
	private String readLineBr; // temporäre Variable die gelesenen Line wird hier abgespeichert.
	private String outputString = null; // gewünster text nach welchem im dokument gesucht werden sollte
	private File outputTextFile = null; // Pfad des Dokument .txt am ende des Pfad nicht vergessen!!!

	public Boolean getFound() {
		return found;
	}

	public void compare(String inputString, String inputTextFile)  {
		
		this.found= null; // found ist das Ergbiniss. Vor jeder Prüfung wird der Wert gelöscht, weil mehrer Methoden zugreifen.
		this.outputString = inputString;
		File outputTextFile = new File(inputTextFile);
		BufferedReader br=null;
		try {
			br = new BufferedReader(new FileReader(outputTextFile));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			while ((readLineBr = br.readLine()) != null) {
			
				if (readLineBr.contains(outputString)) {
// hier eintragen was gemaht werden soll wenn der text gefunden wurde
					found = true;
					this.found = found;
					
					break;

				} else {
					found = false;
					this.found = found;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}

//if (!startOrt) {
//Textfilereader t = new Textfilereader(); // Classe Aufrufen
//String inputTextFile = "src\\start\\plz.txt"; // Wichtig ab src den Pfand angeben. File im Package speichern
//String inputString = // z.B. auftrag.getStartOrt(); // zuprüfender String eingeben.
//
//t.compare(inputString, inputTextFile);
// lokale Variable = t.getFound(); // boolean Ergebnis der Abfrage
//
//}