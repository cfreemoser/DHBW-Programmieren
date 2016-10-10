package de.dhbwka.java.klausurn.jbay;

/**
 * Created by cem on 09.10.16.
 */
public class Bieter {
    private final String vorname;
    private final String nachname;

    public Bieter(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getFullName() {
        return vorname + " " + nachname;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Bieter) obj).getFullName().equals(getFullName());
    }
}
