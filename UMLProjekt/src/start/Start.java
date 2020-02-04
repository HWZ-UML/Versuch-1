package start;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

import auftrag.Auftrag;
import auftrag.Auftragsmanagement;
import enums.Auftragsstatus;
import enums.Fahrzeugklasse;
import enums.Farbe;
import enums.Marke;
import enums.Status;
import enums.Treibstoff;
import fahrzeuginfo.Auto;
import fahrzeuginfo.Automanagement;
import fahrzeuginfo.Model;
import kundeninfo.Adresse;
import kundeninfo.Firmenkunde;
import kundeninfo.Fuehrerschein;
import kundeninfo.Kunde;
import kundeninfo.Kundenmanagement;
import kundeninfo.Privatkunde;
import kundeninfo.Zahlungsmittel;

public class Start {

	private Kundenmanagement kundenmanagement = new Kundenmanagement();
	private Automanagement automanagement = new Automanagement();
	private Auftragsmanagement auftragsmanagement = new Auftragsmanagement();
	private Scanner scan;
	private String eingabe = null;
	private Kunde kunde = new Kunde();
	private Privatkunde privatkunde = new Privatkunde();
	private Firmenkunde firmenkunde = new Firmenkunde();
	private Model model = new Model();
	private Auftrag auftrag = new Auftrag();
	int tage = 0;
	Auto result;

	public static void main(String[] args) throws Exception {
		(new Start()).start(); /*
								 * springt in Start-Methode, wird gemacht, damit nicht alle Methoden static
								 * gemacht werden müssen
								 */

	}

	private void start() throws Exception {

		Fuehrerschein fuehrerschein1 = new Fuehrerschein(225566, LocalDate.of(2020, 10, 01));
		Adresse adresse1 = new Adresse("Musterstrasse", 1, 8840, "Musterhausaen", "muster@gmail.com", 0444000101);
		Zahlungsmittel zahlungsmittel1 = new Zahlungsmittel("Visa", 44567, LocalDate.of(2021, 11, 02));
		Kunde kunde1 = new Kunde((kundenmanagement.getSize() + 1), "Muster", "Benutzer 1", "PassWort123",
				fuehrerschein1, adresse1, zahlungsmittel1);

		kundenmanagement.addKunde(kunde1);

		Model modelClassic = new Model("Classic", Fahrzeugklasse.Combi, Marke.Toyota, Treibstoff.Benzin, 5,
				((100.00 + model.getFixZuschlag()) * model.getMwst()));
		Model modelComfort = new Model("Comfort", Fahrzeugklasse.OffRoader, Marke.Audi, Treibstoff.Diesel, 4,
				((200.00 + model.getFixZuschlag()) * model.getMwst()));
		Model modelExtra = new Model("Extra", Fahrzeugklasse.Limousine, Marke.Mercedes, Treibstoff.Elektrizität, 10,
				((300.00 + model.getFixZuschlag()) * model.getMwst()));

		Auto auto1 = new Auto((automanagement.getSize() + 1), "ZH444555", 56001, LocalDate.of(2013, 01, 13),
				modelClassic, Status.verfuegbar, Farbe.grau);

		automanagement.addAuto(auto1);

		Auto auto2 = new Auto((automanagement.getSize() + 1), "ZH111223", 44000, LocalDate.of(2015, 03, 22),
				modelComfort, Status.ausgeliehen, Farbe.weiss);

		automanagement.addAuto(auto2);

		Auto auto3 = new Auto((automanagement.getSize() + 1), "ZH45646", 5115, LocalDate.of(2019, 01, 03), modelComfort,
				Status.verfuegbar, Farbe.schwarz);

		automanagement.addAuto(auto3);

		Auto auto4 = new Auto((automanagement.getSize() + 1), "ZH001002", 3001, LocalDate.of(2093, 06, 15), modelExtra,
				Status.inReinigung, Farbe.schwarz);

		automanagement.addAuto(auto4);

		System.out.println("Sind Sie bereits registriert? J/N");
		scan = new Scanner(System.in);
		eingabe = scan.nextLine();

		if (eingabe.equalsIgnoreCase("J")) {
			System.out.println("Bitte geben Sie Ihren Benutzernamen ein");
			scan = new Scanner(System.in);
			eingabe = scan.nextLine();

			String benutzername = eingabe;

			System.out.println("Bitte geben Sie Ihr Passwort ein");
			scan = new Scanner(System.in);
			eingabe = scan.nextLine();

			String passwort = eingabe;

			kunde = login(benutzername, passwort);

			if (ueberpruefeLogin(kunde)) {
				System.out.println("Hallo " + kunde.getBenutzername() + ", \n" + "Sie sind nun eingeloggt! \n");
				kundenmanagement.druckeKundenangaben();
				menu();
			}

			else if (eingabe.equalsIgnoreCase("N")) {

				registrieren();
				start();
			}

			else { // wenn nichts richtiges eingegeben wird, zurück zum start
				System.out.println("Ungültige Eingabe!");
				start();
			}
		}
	}

	private void registrieren() {

		System.out.println("Sind Sie ein Privatkunde oder Firmenkunde? P/F");
		scan = new Scanner(System.in);
		eingabe = scan.nextLine();

		if (!(eingabe.equalsIgnoreCase("P") || eingabe.equalsIgnoreCase("F"))) {
			System.out.println("Ungültige Eingabe!");
			registrieren();
		}

		else {

			if (eingabe.equalsIgnoreCase("P")) {
				erfassePrivatkundenangabe();
				erfasseAdresse();
				erfasseFuehrerschein();
				erfasseZahlungsmittel();
				System.out.println("Sie sind nun registriert.");
			}

			else if (eingabe.equalsIgnoreCase("F")) {
				erfasseFirmenkundenangabe();
				erfasseAdresse();
				erfasseFuehrerschein();
				erfasseZahlungsmittel();
				System.out.println("Sie sind nun registriert.");
			}
		}
	}

	private void erfassePrivatkundenangabe() {

		System.out.println("Bitte geben Sie Ihren Namen ein.");
		scan = new Scanner(System.in);
		String a = scan.nextLine();
		kunde.setName(a);
		System.out.println(kunde.getName());

		kunde.setKundenummer((kundenmanagement.getSize() + 1));
		kunde.setUmsatz(0);
		kunde.setLogin(false);
		kunde.setGesperrt(false);

		System.out.println("Bitte geben Sie Ihren Vornamen ein.");
		scan = new Scanner(System.in);
		String b = scan.nextLine();
		privatkunde.setVorname(b);
		System.out.println(privatkunde.getVorname());

		System.out.println("Bitte geben Sie Ihr Geburtsdatum ein.");
		scan = new Scanner(System.in);
		String c = scan.nextLine();
		LocalDate datum = LocalDate.parse(c);
		privatkunde.setGeburtsdatum(datum);
		System.out.println(privatkunde.getGeburtsdatum());

		System.out.println("Bitte geben Sie Ihr Benutzername ein.");
		scan = new Scanner(System.in);
		String d = scan.nextLine();
		privatkunde.setBenutzername(d);
		System.out.println(privatkunde.getBenutzername());

		System.out.println("Bitte geben Sie Ihr Passwort ein.");
		scan = new Scanner(System.in);
		String e = scan.nextLine();
		privatkunde.setPasswort(e);
		System.out.println(privatkunde.getPasswort());

		kundenmanagement.addKunde(privatkunde);
	}

	private void erfasseFirmenkundenangabe() {

		kunde.setKundenummer((kundenmanagement.getSize() + 1));
		kunde.setUmsatz(0);
		kunde.setLogin(false);
		kunde.setGesperrt(false);

		System.out.println("Bitte geben Sie Ihren Firmennamen ein.");
		scan = new Scanner(System.in);
		String a = scan.nextLine();
		kunde.setName(a);
		System.out.println(kunde.getName());

		System.out.println("Bitte geben Sie eine Referenz an.");
		scan = new Scanner(System.in);
		String b = scan.nextLine();
		firmenkunde.setReferenz(b);
		System.out.println(firmenkunde.getReferenz());

		System.out.println("Bitte geben Sie Ihr Benutzername ein.");
		scan = new Scanner(System.in);
		String d = scan.nextLine();
		privatkunde.setBenutzername(d);
		System.out.println(privatkunde.getBenutzername());

		System.out.println("Bitte geben Sie Ihr Passwort ein.");
		scan = new Scanner(System.in);
		String e = scan.nextLine();
		privatkunde.setPasswort(e);
		System.out.println(privatkunde.getPasswort());

		kundenmanagement.addKunde(firmenkunde);
	}

	public void erfasseAdresse() {

		Adresse adresse = new Adresse();

		System.out.println("Bitte geben Sie Ihre Adresse ein.");
		System.out.print("Strasse: ");
		scan = new Scanner(System.in);
		String d = scan.nextLine();
		adresse.setStrasse(d);
		System.out.println(adresse.getStrasse());

		System.out.print("Hausnummer: ");
		scan = new Scanner(System.in);
		String e = scan.nextLine();
		adresse.setHausnummer(Integer.parseInt(e));
		System.out.println(adresse.getHausnummer());

		System.out.print("Postleitzahl: ");
		scan = new Scanner(System.in);
		String f = scan.nextLine();
		adresse.setPostleitzahl(Integer.parseInt(f));
		System.out.println(adresse.getPostleitzahl());

		System.out.print("Ort: ");
		scan = new Scanner(System.in);
		String g = scan.nextLine();
		adresse.setOrt(g);
		System.out.println(adresse.getOrt());

		System.out.println("Email: ");
		scan = new Scanner(System.in);
		String h = scan.nextLine();
		adresse.setEmail(h);
		System.out.println(adresse.getEmail());

		System.out.println("Telefon: ");
		scan = new Scanner(System.in);
		String i = scan.nextLine();
		adresse.setTelefon(Integer.parseInt(i));
		System.out.println(adresse.getTelefon());

	}

	private void erfasseFuehrerschein() {

		Fuehrerschein fuehrerschein = new Fuehrerschein();

		System.out.println("Bitte geben Sie Ihre Führerscheinangaben ein.");
		System.out.print("Führerscheinnummer: ");
		scan = new Scanner(System.in);
		String a = scan.nextLine();
		fuehrerschein.setFuehrerscheinnummer(Integer.parseInt(a));
		System.out.println(fuehrerschein.getFuhrerscheinnummer());

		System.out.print("Ablaufdatum: ");
		scan = new Scanner(System.in);
		String b = scan.nextLine();
		LocalDate datum = LocalDate.parse(b);
		fuehrerschein.setFuehrerscheinAblaufdatum(datum);
		// fuehrerschein.setfuehrerscheinAblaufdatum(LocalDate myDAte =
		// LocalDate.parse(b);
		System.out.println(fuehrerschein.getFuehrerscheinAblaufdatum());

	}

	private void erfasseZahlungsmittel() {

		Zahlungsmittel zahlungsmittel = new Zahlungsmittel();

		System.out.println("Bitte geben Sie Ihre Kreditkartenangaben ein.");
		System.out.print("Kreditkartenart: ");
		scan = new Scanner(System.in);
		String a = scan.nextLine();
		zahlungsmittel.setKreditkartenart(a);
		System.out.println(zahlungsmittel.getKreditkartenart());

		System.out.print("Kreditkartennummer: ");
		scan = new Scanner(System.in);
		String b = scan.nextLine();
		zahlungsmittel.setKreditkartennummer(Integer.parseInt(b));
		System.out.println(zahlungsmittel.getKreditkartennummer());

		System.out.print("Ablaufdatum der Karte: ");
		scan = new Scanner(System.in);
		String c = scan.nextLine();
		LocalDate datum = LocalDate.parse(c);
		zahlungsmittel.setAblaufdatumKarte(datum);
		System.out.println(zahlungsmittel.getAblaufdatumKarte());

	}

	private Kunde login(String benutzername, String passwort) throws Exception {
		if (kundenmanagement.getKunde(benutzername) == null) {
			System.out.println("Benutzer nicht gefunden");
			start();
			return null;
		} else {
			Kunde kunde = kundenmanagement.getKunde(benutzername);
			if (kunde.getPasswort().equals(passwort)) {
				erstelleSitzung(kunde);
				return kunde;
			} else {
				System.out.println("Benutzername oder Passwort falsch");
				start();
				return null;
			}
		}
	}

	private void erstelleSitzung(Kunde kunde) {
		if (kunde.getLogin()) {
			System.out.println("Der Benutzer ist bereits angemeldet");
		} else {
			kunde.setLogin(true);
		}
	}

	private boolean ueberpruefeLogin(Kunde kunde) {
		return kunde.getLogin();
	}

	private void menu() throws Exception {
		System.out.println("Auftrag erstellen (A) oder Kundenangaben bearbeiten (B)?");
		scan = new Scanner(System.in);
		eingabe = scan.nextLine();

		if (eingabe.equalsIgnoreCase("A")) {
			erstellenAuftrag();
		}

		else if (eingabe.equalsIgnoreCase("B")) {
			bearbeitenKundenprofil();
		}

		else {
			System.out.println("Ungültige Eingabe!");
			menu();
		}
	}

	private void erstellenAuftrag() throws Exception {

		auftrag.setAuftragsnummer((auftragsmanagement.getSize() + 1));
		auftrag.setAuftragsdatum(berechnenTagesdatum());

		System.out.println("Geben Sie Ihre Kundennummer ein.");
		scan = new Scanner(System.in);
		String k = scan.nextLine();
		int kunde = Integer.parseInt(k);
		auftrag.setKundennummer(kunde);
		;
		System.out.println(auftrag.getKundennummer()); // Bessere Alternative?

		System.out.println("Wählen Sie das Startdatum der Mietdauer: Bsp. 1901-01-01");
		scan = new Scanner(System.in);
		String b = scan.nextLine();
		LocalDate startdatum = LocalDate.parse(b);
		auftrag.setDatumVon(startdatum);
		System.out.println(auftrag.getDatumVon());

		System.out.println("Wählen Sie das Enddatum der Mietdauer: Bsp. 1901-01-01 ");
		scan = new Scanner(System.in);
		String c = scan.nextLine();
		LocalDate enddatum = LocalDate.parse(c);
		auftrag.setDatumBis(enddatum);
		System.out.println(auftrag.getDatumBis());

		berechneDauer();
		auftrag.setMietdauer(tage);

		System.out.println("Wählen Sie das Startort der Miete: ");
		scan = new Scanner(System.in);
		String d = scan.nextLine();
		auftrag.setStartOrt(d);
		System.out.println(auftrag.getStartOrt());

		System.out.println("Wählen Sie das Rückgabeort: ");
		scan = new Scanner(System.in);
		String e = scan.nextLine();
		auftrag.setZielOrt(e);
		System.out.println(auftrag.getZielOrt());

		auftrag.setEinsatzgebiet("Schweiz");
		System.out.println("Das Mietauto darf nur im folgenden Einsatzgebiet verwendet werden: ");
		System.out.println(auftrag.getEinsatzgebiet());

		// auto auswählen:

		System.out.println("Wählen Sie eines der untenstehenden Auto aus: " + "\n");
		automanagement.druckAutoliste();

		System.out.println("Geben Sie die Nummer des gewünschten Fahrzeugs ein. / Bsp. Auto 1 - Eingabe 1");
		scan = new Scanner(System.in);
		String a = scan.nextLine();
		int autozahl = Integer.parseInt(a);
		result = automanagement.getAutoliste().get(autozahl);

		System.out.println(result.getKennzeichen()); // mit result weiterarbeiten
		auftrag.setAuto(result);

		auftragsmanagement.addAuftrag(auftrag);
		auftragsmanagement.druckeAuftrag();

		auftrag.setAuftragstatus(Auftragsstatus.inPruefung);

		validierung();

	}

	private String berechnenTagesdatum() {
		Date date = java.util.Calendar.getInstance().getTime();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
		String dateString = dateFormatter.format(date);
		return dateString;
	}

	private int berechneDauer() {
		tage = (int) ChronoUnit.DAYS.between(auftrag.getDatumVon(), auftrag.getDatumBis());
		return tage;
	}

	// Validierung:

	private void validierung() throws Exception {

		boolean autoVerfuegbar = false; // abfrage ausgewältes auto == Status verfuegbar

		boolean startDatum = false; // Startdatum > heute
		boolean endDatum = false;// Enddatum > Startdatum

		boolean startOrt = false; // in der Schweiz pruefung zur zeit nicht aktiv
		boolean zielOrt = false; // in der Schweiz pruefung zur zeit nicht aktiv

		// boolean kreditkartenAblaufdatum = false; // endDatumAuftrag +30 Days <
		// KreditkartenAblaufdatum
		boolean zahlungsinformationen = false;// Kartentyp Vorhanden, Kreditkartennummer voständig
		boolean pruefungRueckantwortAntwortKreditkartenAnbieter = false; // private Boolean antwortKreditkartenAnbieter;
																			// mit get Set in auftrag erfasst
		// ist nur für die fehlermeldung relevant. Könnte auch mit einem
		// auftrag.getAntwortKreditkartenAnbieter() gelösst werden

		int trueCount = 0;
		int loopantwortKreditkartenAnbiete = 30;// wie oft soll auftrag.getAntwortKreditkartenAnbieter() abgefragt
												// werden, einstellung 20 Sec pro loop.
		LocalDate today = LocalDate.now();
		LocalDate d1 = auftrag.getDatumVon();
		LocalDate d2 = auftrag.getDatumBis();

		Textfilereader t = new Textfilereader();
		String inputTextFile = "src\\start\\plz.txt";
		
		System.out.println("Ihre Auftrag wird bearbeitet - Bitte haben Sie ein wenig Gedult");

		// Autoverfügbar?

		if ((result.getStatus()) == Status.verfuegbar) {
			autoVerfuegbar = true;
			trueCount++;
		}

		// Datum wird geprüft
		if (d1.isAfter(today)) {
			startDatum = true;
			trueCount++;
		}

		if (d2.isAfter(d1)) {
			endDatum = true;
			trueCount++;
		}
		// Ort wird geprüft
		if (!startOrt) {

			String inputString = auftrag.getStartOrt();
			
			t.compare(inputString, inputTextFile);
			
			startOrt = t.getFound();

			if (startOrt) {
				trueCount++;
			}
		}

		if (!zielOrt) {

			String inputString = auftrag.getZielOrt();
			t.compare(inputString, inputTextFile);
			zielOrt = t.getFound();

		}
		if (zielOrt) {
			trueCount++;
		}

		for (int i = 0; i <= loopantwortKreditkartenAnbiete; i++) {// 30 x loop loopantwortKreditkartenAnbiete; anfang
																	// vom block is die variable deffiniert.
			if (auftrag.getAntwortKreditkartenAnbieter() == false) { // wenn noch keine rückantwort gekommen == falsh.
				// schnittstelle wird bei einer rückantwort mit set den wert von
				// antwortKreditkartenAnbiete änder auf true.

				try {
					Thread.sleep(20000);
				} // 20 sec * loopantwortKreditkartenAnbiete;
				catch (Exception ex) {
					ex.printStackTrace();
				}

				// **************************************************************************
				// hard codiert für einen Testversion, schnittstelle fehlt noch. Code entfernen
				// für prod.
				if (i == 2) {
					auftrag.setAntwortKreditkartenAnbieter(true);
				}
				// ***************************************************************************
			}

			else {
				trueCount++;
				i = loopantwortKreditkartenAnbiete;
				pruefungRueckantwortAntwortKreditkartenAnbieter = true;
			} // for wird beendet. loopantwortKreditkartenAnbiete

		}
		// }

		// *** Prüfung korrekt
		if (trueCount == 6) { // wenn alles stimmt wird dies ausgeführt und weitergeleiten an....... zur Zeit
								// Line 419
			System.out.println("Die Prüfung ist Erfolgreich Abgschlossen und Ihren Auftrag wurde angenommen");
			result.setStatus(Status.ausgeliehen);

		}

		// ***Fehler wurde generiert 1. Print was ist falsch 2. Kunde Entscheide über
		// weiteres vorgehen
		else {
			System.out.println("Es ist ein Fehler aufgetreten:");
			if (!autoVerfuegbar) {
				System.out.println("Auto nicht verfügbar");
			}
			if (!startDatum) {
				System.out.println("Startdatum liegt in der Vergangenheit.");
			}
			if (!endDatum) {
				System.out.println("Enddatum liegt vor dem Startdatum.");
			}

			if (!pruefungRueckantwortAntwortKreditkartenAnbieter) {
				System.out
						.println("Buchungsbestätigung von der Bank nicht erhalten. Bitte Kontaktieren Sie Ihre Bank.");
			}
			if (!startOrt) {
				System.out.println("Start Ort ist ausserhalb der Schweiz oder unbekannter Ort.");
			}
			if (!zielOrt) {
				System.out.println("Ziel Ort ist ausserhalb der Schweiz oder unbekannter Ort.");
			}

			System.out.println(
					"Drücken Sie für eine erneute Eingabe N oder für einen Bearbeitung von einem Sachbearbeiter S");
			scan = new Scanner(System.in);
			eingabe = scan.nextLine();

			if (eingabe.equalsIgnoreCase("N")) {
				erstellenAuftrag();
			}
			if (eingabe.equalsIgnoreCase("S")) {
				System.out.println("Sie werden von uns Kontaktiert");
				// Methode eibauen für info an Sachbearbeiter,
			}

			else {
				erstellenAuftrag();
			}
		}
	}//

	// ende block Valiedierung

	// Kundenprofil bearbeiten:

	private void bearbeitenKundenprofil() throws Exception {

		System.out.println("Geben Sie bitte ihre Kundennummer ein.");
		scan = new Scanner(System.in);
		String a = scan.nextLine();
		int kundenzahl = Integer.parseInt(a);
		Kunde result = kundenmanagement.getKundenliste().get(kundenzahl);

		System.out.print("Ihr aktuell gespeicherten Name ist: ");
		System.out.println(kunde.getName());
		System.out.println("Bitte geben Sie Ihren neun Namen ein.");
		scan = new Scanner(System.in);
		String b = scan.nextLine();
		kunde.setName(b);
		System.out.println(kunde.getName() + "\n");

		System.out.print("Ihr aktuell gespeicherten Vorname ist: ");
		System.out.println(privatkunde.getVorname());
		System.out.println("Bitte geben Sie Ihren neuen Vornamen ein.");
		scan = new Scanner(System.in);
		String c = scan.nextLine();
		privatkunde.setVorname(c);
		System.out.println(privatkunde.getVorname() + "\n");

		System.out.print("Ihr aktuell gespeicherten Benutzername ist: ");
		System.out.println(kunde.getBenutzername());
		System.out.println("Bitte geben Sie Ihr Benutzername ein.");
		scan = new Scanner(System.in);
		String d = scan.nextLine();
		privatkunde.setBenutzername(d);
		System.out.println(privatkunde.getBenutzername() + "\n");

		System.out.print("Ihr aktuell gespeicherten Passwort ist: ");
		System.out.println(kunde.getPasswort());
		System.out.println("Bitte geben Sie Ihr Passwort ein.");
		scan = new Scanner(System.in);
		String e = scan.nextLine();
		privatkunde.setPasswort(e);
		System.out.println(privatkunde.getPasswort() + "\n");

		System.out.println("Ihre neuen Daten sind: ");
		System.out.println(kunde.getName());
		System.out.println(privatkunde.getVorname());
		System.out.println(kunde.getBenutzername());
		System.out.println(kunde.getPasswort() + "\n");

		System.out.println("Sie haben ihr Kundenprofil erfolgreich geändert!" + "\n");

		menu();

	}
}
