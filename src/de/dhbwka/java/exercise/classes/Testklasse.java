package de.dhbwka.java.exercise.classes;

public class Testklasse {
	public static void main(String[] args) {
		
		//Tests unvöllstandig, da langweilig.
		
		//Radio testen
		Radio radio = new Radio();
		System.out.println(radio.toString());
		
		//Punkt testen
		Point point1 = new Point(2, 2);
		Point point2 = new Point(4, 2);
		System.out.println(point1.toString());
		System.out.println(point1.getAbstandTo(point2));
		System.out.println(point1.getAbstandToUrsprung());
		
		//Account testen
		Account account = new Account("Christoph", "Emig", 11111111, 10000000, 0);
		System.out.println(account.getKontostand());
		account.auszahlen(10000);
		System.out.println(account.getKontostand());
	}
}
