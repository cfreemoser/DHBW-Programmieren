package de.dhbwka.java.klausurn.jbay;

/**
 * Created by cem on 09.10.16.
 */
public class Gebot {
    Bieter bieter;
    double hoechstbetrag;

    public Gebot(Bieter bieter, double hoechstbetrag) {
        this.bieter = bieter;
        this.hoechstbetrag = hoechstbetrag;
    }

    public Bieter getBieter() {
        return bieter;
    }

    public void setBieter(Bieter bieter) {
        this.bieter = bieter;
    }

    public double getHoechstbetrag() {
        return hoechstbetrag;
    }

    public void setHoechstbetrag(double hoechstbetrag) {
        this.hoechstbetrag = hoechstbetrag;
    }
}
