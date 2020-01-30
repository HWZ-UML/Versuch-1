package start;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Textfilereader {

	private Boolean found = null; // wird auf true oder false geändert wenn der text vorhanden ist = true, wenn
									// nicht vorhanden false
	private String readLineBr; // temporäre Variable die gelesenen Line wird hier abgespeichert.
	private String outputString = null; // gewünster text nach welchem im dokument gesucht werden sollte
	private String outputTextFile = null; // Pfad des Dokument .txt am ende des Pfad nicht vergessen!!!

	public Boolean getFound() {
		return found;
	}

	public void compare(String inputString, String inputTextFile, Boolean found) {
		this.outputString = inputString; // wechseln von eingabe zu temp. wert (kann bei darf auch dur get/set ersetz werden)
		this.outputTextFile = inputTextFile; 
		System.out.println(outputTextFile);// wechseln von eingabe zu temp wert (kann bei darf auch dur get/set ersetz werden)
// get /set nicht machen, da diese variante die handhabung einschränkt und somit fehler vermeidet.
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(outputTextFile));
			
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
				br.close();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	Textfilereader t = new Textfilereader();
//	{
//	String inputString = "6050";
//	String inputTextFile = "C:\\Users\\gmx12\\eclipse-workspace\\UMLProject\\src\\start\\plz.txt";
//Boolean found = null;
//	t.compare(inputString, inputTextFile, found);{ //throws Execption nehmen 	
//		found= t.getFound();// found wird aktualisiert und ist das ergebniss der abfrage. 
//		
//	}}
	
}
