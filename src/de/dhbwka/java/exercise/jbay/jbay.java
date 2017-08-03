package de.dhbwka.java.exercise.jbay;

public class jbay {
	public static void main(String[] args) {
		Auktionshaus jbay = new Auktionshaus();
		jbay.addAuktion(new Auktion(
				new Ware("Turnschule","Tolle Turnschuhe, kaum getragen"),2));
		jbay.addAuktion(new Auktion(
				new Ware("iPad","Nagelneues iPad 3"),4));
		jbay.addAuktion(new Auktion(
				new Ware("Currywurst","Scharf, ohne Pommes"),5));
		System.out.println(jbay.getAuktionen().toString());
		BieterTerminal b1=new BieterTerminal(new Bieter("Micky","Mouse"),jbay);
	}

}
