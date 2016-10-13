package de.dhbwka.java.klausurn.totoSpiel;

/**
 * Created by cem on 13.10.16.
 */
public class Tipp {
    final Paarung paarung;
    final int tipp;

    public Tipp(Paarung paarung, int tipp) {
        this.paarung = paarung;
        this.tipp = tipp;
    }

    public Paarung getPaarung() {
        return paarung;
    }

    public int getTipp() {
        return tipp;
    }
}
