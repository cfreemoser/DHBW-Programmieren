package de.dhbwka.java.klausurn.bookingForm;

import java.util.Calendar;

/**
 * Created by cem on 10.10.16.
 */
public class Flug {
    final String name;
    final Airline airline;
    final Destination from;
    final Destination to;
    final Calendar depature;
    final Calendar landing;
    final Sitz[][] sitzs;

    public Flug(String name, Airline airline, Destination from, Destination to, Calendar depature, Calendar landing, Sitz[][] sitzs) {
        this.name = name;
        this.airline = airline;
        this.from = from;
        this.to = to;
        this.depature = depature;
        this.landing = landing;
        this.sitzs = sitzs;
    }

    // 15 4
    public Flug(String name, Airline airline, Destination from, Destination to, int reihen, int sitzeProReihe) {
        this.sitzs = new Sitz[reihen][sitzeProReihe];
        //create sitzes
        for (int reihe = 0; reihe < reihen; reihe++) {
            for (int position = 0; position < sitzeProReihe; position++) {
                Sitz sitz = new Sitz(reihe, position, Buchungsstatus.FREI);
                sitzs[reihe][position] = sitz;
            }
        }

        this.name = name;
        this.airline = airline;
        this.from = from;
        this.to = to;
        this.depature = Calendar.getInstance();
        Calendar temp = Calendar.getInstance();
        temp.setTimeInMillis(System.currentTimeMillis() + 120 * 60000);
        this.landing = temp;
    }

    public int freiePlaetze() {
        int i = 0;
        for (Sitz[] some : sitzs)
            for (Sitz someSitz : some)
                if (someSitz.getBuchungsstatus() == Buchungsstatus.FREI) i++;

        return i;
    }

    public String getName() {
        return name;
    }

    public Airline getAirline() {
        return airline;
    }

    public Destination getFrom() {
        return from;
    }

    public Destination getTo() {
        return to;
    }

    public Calendar getDepature() {
        return depature;
    }

    public Calendar getLanding() {
        return landing;
    }

    public Sitz[][] getSitzs() {
        return sitzs;
    }
}
