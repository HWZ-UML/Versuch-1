package kundeninfo;
import java.time.LocalDate;

public class Fuehrerschein {

	private int fuehrerscheinnummer;
	private LocalDate fuehrerscheinAblaufdatum;
	
public int getFuhrerscheinnummer() {
	return fuehrerscheinnummer;
}

public LocalDate getFuehrerscheinAblaufdatum() {
	return fuehrerscheinAblaufdatum;
}

public void setFuehrerscheinnummer(int fuehrerscheinnummer) {
	this.fuehrerscheinnummer = fuehrerscheinnummer;
}

public void setFuehrerscheinAblaufdatum(LocalDate fuerherscheinAblaufdatum) {
	this.fuehrerscheinAblaufdatum = fuehrerscheinAblaufdatum;
}

public Fuehrerschein() {

}

public Fuehrerschein(int i, LocalDate a) {

}

}
