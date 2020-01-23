package start;

import kundeninfo.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import auftrag.Auftrag;
import auftrag.Auftragsmanagement;

import java.util.Date;

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

	public static void main(String[] args) {
		(new Start()).start(); /*
								 * springt in Start-Methode, wird gemacht, damit nicht alle Methoden static
								 * gemacht werden müssen
								 */

	}

	private void start() {

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
				erstellenAuftrag();
			}
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

	// Autoinformationen
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

	private Kunde login(String benutzername, String passwort) {
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
			kunde.setLogin(true);// könnte für alle Attribute zum Anpassen benutzt werden - Aufwändig
		}
	}

	private boolean ueberpruefeLogin(Kunde kunde) {
		return kunde.getLogin();
	}

	private void erstellenAuftrag() {

		auftrag.setAuftragsnummer((auftragsmanagement.getSize() + 1));
		auftrag.setAuftragsdatum(berechnenTagesdatum());

		System.out.println("Geben Sie Ihre Kundennummer ein.");
		scan = new Scanner(System.in);
		String k = scan.nextLine();
		int kunde = Integer.parseInt(k);
		auftrag.setKundennummer(kunde);
		;
		System.out.println(auftrag.getKundennummer()); // Bessere Alternative?

		// auto auswählen

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

		System.out.println("Wählen Sie eines der untenstehenden Auto aus: " + "\n");
		automanagement.druckAutoliste();

		System.out.println("Geben Sie die Nummer des gewünschten Fahrzeugs ein. / Bsp. Auto 1 - Eingabe 1");
		scan = new Scanner(System.in);
		String a = scan.nextLine();
		int auto = Integer.parseInt(a);
		auftrag.setAutonummer(auto);
		System.out.println(auftrag.getAutonummer());
		
		auftragsmanagement.addAuftrag(auftrag);
		auftragsmanagement.druckeAuftrag();

			auftrag.setAuftragstatus(Auftragsstatus.inPruefung);

			System.out.println("Ihr Auftrag wird geprüft!");
		}

		// Validierung

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

}
