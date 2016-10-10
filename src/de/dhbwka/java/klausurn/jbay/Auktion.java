package de.dhbwka.java.klausurn.jbay;

import java.util.Calendar;

/**
 * Created by cem on 09.10.16.
 */
public class Auktion {
    static final double INCREMENT = 1.0;

    Ware ware;
    Gebot gebot = null;
    double preis = 0.0;
    Calendar ende;

    public Auktion(Ware ware, int dauer) {
        this.ware = ware;
        Calendar zeit = Calendar.getInstance();
        zeit.setTimeInMillis(System.currentTimeMillis() + 60000 * dauer);
        this.ende = zeit;
    }

    public boolean gebotAbgeben(Gebot g) {
        if (g.getHoechstbetrag() < preis + INCREMENT) {
            return false;
        } else if (gebot == null) {
            gebot = g;
            preis = INCREMENT;
            return true;
        } else if (g.getHoechstbetrag() >= preis + INCREMENT && g.getHoechstbetrag() <= gebot.getHoechstbetrag()) {
            preis = g.getHoechstbetrag() + INCREMENT;
            return false;
        } else if (g.getHoechstbetrag() >= preis + INCREMENT && g.getHoechstbetrag() > gebot.getHoechstbetrag()) {
            preis = gebot.getHoechstbetrag() + INCREMENT;
            return true;
        } else if (gebot.getBieter().equals(gebot.getBieter())) {
            if (g.getHoechstbetrag() > gebot.getHoechstbetrag()) {
                gebot = g;
                preis = preis + INCREMENT;
                return true;
            } else return false;
        } else return false;
    }

    public Ware getWare() {
        return ware;
    }

    public void setWare(Ware ware) {
        this.ware = ware;
    }

    public Gebot getGebot() {
        return gebot;
    }

    public void setGebot(Gebot gebot) {
        this.gebot = gebot;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public Calendar getEnde() {
        return ende;
    }
}
