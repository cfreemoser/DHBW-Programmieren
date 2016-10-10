package de.dhbwka.java.exercise.classes;

/**
 * Created by cem on 13.02.16.
 */
public class Account {
    private final int kontonummer;

    private double guthaben;
    private String kontoinhaber;

    public Account(int kontonummer, String kontoinhaber) {
        this.kontoinhaber = kontoinhaber;
        this.kontonummer = kontonummer;
    }

    public String getKontoinhaber() {
        return kontoinhaber;
    }

    public void setKontoinhaber(String kontoinhaber) {
        this.kontoinhaber = kontoinhaber;
    }

    public double getGuthaben() {
        return guthaben;
    }

    public void einzahlen(double betrag) {
        if (betrag > 0) guthaben += betrag;
    }

    public void auszahlen(double betrag) {
        if (betrag > guthaben) System.out.print(" Deckung nicht ausreichend! ");
        else guthaben = -betrag;
    }

    @Override
    public String toString() {
        return "Konto Nr. " + kontonummer + "(" + kontoinhaber + "), Stand: " + guthaben + ")";
    }
}
