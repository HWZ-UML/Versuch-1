package kundeninfo;

import java.time.LocalDate;

public class Zahlungsmittel { //Konstruktor bauen 

	private String kreditkartenart;
	private int kreditkartennummer;
	private LocalDate ablaufdatumKarte;
	
public String getKreditkartenart() {
	return kreditkartenart;
}

public int getKreditkartennummer() {
	return kreditkartennummer;
}

public LocalDate getAblaufdatumKarte() {
	return ablaufdatumKarte;
}

public void setKreditkartenart(String kreditkartenart) {
	this.kreditkartenart = kreditkartenart;
}

public void setKreditkartennummer(int kreditkartennummer) {
	this.kreditkartennummer = kreditkartennummer;
}

public void setAblaufdatumKarte(LocalDate ablaufdatumKarte) {
	this.ablaufdatumKarte = ablaufdatumKarte;
}

public Zahlungsmittel(String kreditkartenart, int kreditkartennummer, LocalDate ablaufdatumKarte) {
	this.kreditkartenart = kreditkartenart;
	this.kreditkartennummer = kreditkartennummer;
	this.ablaufdatumKarte = ablaufdatumKarte;
}

public Zahlungsmittel() {
	
}
}
