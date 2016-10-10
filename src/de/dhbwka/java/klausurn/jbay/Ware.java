package de.dhbwka.java.klausurn.jbay;

/**
 * Created by cem on 09.10.16.
 */
public class Ware {
    final String title;
    final String beschreibung;

    public Ware(String title, String beschreibung) {
        this.title = title;
        this.beschreibung = beschreibung;
    }

    public String getTitle() {
        return title;
    }

    public String getBeschreibung() {
        return beschreibung;
    }
}
