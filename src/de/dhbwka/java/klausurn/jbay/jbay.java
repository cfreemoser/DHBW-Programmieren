package de.dhbwka.java.klausurn.jbay;

public class jbay {

    public static void main(String[] args) {
        Auktionshaus jbay = new Auktionshaus();
        jbay.addAuktion(new Auktion(new Ware("Turnschuhe", "Tolle Turnschuhe, kaum getragen"), 2));
        jbay.addAuktion(new Auktion(new Ware("iPad", "Nagelneues iPad 3"), 4));
        jbay.addAuktion(new Auktion(new Ware("Currywurst", "Schard, ohne Pmmes"), 5));

        BieterTerminal b1 = new BieterTerminal(new Bieter("Micky", "Maus"), jbay);
        BieterTerminal b2 = new BieterTerminal(new Bieter("Donald", "Duck"), jbay);

    }
}
