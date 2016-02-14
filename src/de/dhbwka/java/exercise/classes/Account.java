package de.dhbwka.java.exercise.classes;

public class Account {

	private int kontonummer;
	private String vorname;
	private String nachname;
	private long kontostand;
	private long limit;
	
	public Account(String vorname, String nachname, int kontonummer, long kontostand, long limit){
		this.vorname = vorname;
		this.nachname = nachname;
		this.kontonummer = kontonummer;
		this.kontostand = kontostand;
		this.limit = limit;
	}
	
	public String toString(){
		return "Konto Nr. "+kontonummer+" ("+vorname+" "+nachname+"), Stand: "+kontostand+" ct, Limit "+limit+" ct";
	}
	
	public void einzahlen(long betrag){
		if(betrag > 0){
			kontostand+=betrag;
		}else {
			System.out.println("Fehler. Eingabe fehlerhaft.");
		}
	}
	
	public void auszahlen(long betrag){
		if(betrag > 0 && (kontostand - betrag)>=limit){
			kontostand -= betrag;
		}else{
			System.out.println("Fehler. Kontostand zu niedrig.");
		}
	}
	
	public long getKontostand(){
		return kontostand;
	}
	
}
