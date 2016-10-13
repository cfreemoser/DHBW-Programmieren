package de.dhbwka.java.klausurn.totoSpiel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cem on 13.10.16.
 */
public class Tipper {
    final String vorname;
    final String nachname;
    final Totalisator totalisator;

    final List<Tipp> tipps = new ArrayList<>();

    public Tipper(String vorname, String nachname, Totalisator totalisator) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.totalisator = totalisator;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public Totalisator getTotalisator() {
        return totalisator;
    }

    public List<Tipp> getTipps() {
        return tipps;
    }

    public void addTipp(Tipp tipp) {
        tipps.add(tipp);
    }
}
