package de.dhbwka.java.klausurn.bookingForm;

/**
 * Created by cem on 10.10.16.
 */
public class Sitz {
    final int reihe;
    final int postion;
    Buchungsstatus buchungsstatus;

    public Sitz(int reihe, int postion, Buchungsstatus buchungsstatus) {
        this.reihe = reihe;
        this.postion = postion;
        this.buchungsstatus = buchungsstatus;
    }

    public int getReihe() {
        return reihe;
    }

    public int getPostion() {
        return postion;
    }

    public Buchungsstatus getBuchungsstatus() {
        return buchungsstatus;
    }

    public void setBuchungsstatus(Buchungsstatus buchungsstatus) {
        this.buchungsstatus = buchungsstatus;
    }
}
