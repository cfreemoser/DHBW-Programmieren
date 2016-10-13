package de.dhbwka.java.klausurn.totoSpiel;

import java.util.Random;

/**
 * Created by cem on 13.10.16.
 */
public class Paarung {
    final Verein heimVerein;
    final Verein gastVerein;
    int toreHeim;
    int toreGast;


    public Paarung(Verein heimVerein, Verein gastVerein) {
        this.heimVerein = heimVerein;
        this.gastVerein = gastVerein;
    }

    public Verein getHeimVerein() {
        return heimVerein;
    }

    public Verein getGastVerein() {
        return gastVerein;
    }

    public int getToreHeim() {
        return toreHeim;
    }

    public void setToreHeim(int toreHeim) {
        this.toreHeim = toreHeim;
    }

    public int getToreGast() {
        return toreGast;
    }

    public void setToreGast(int toreGast) {
        this.toreGast = toreGast;
    }

    public void spielen() {
        Random random = new Random();
        int summeHeimat = 0;
        for (int i = 0; i <= 3; i++)
            summeHeimat += random.nextInt(7);

        summeHeimat -= 3;
        summeHeimat = Math.round(summeHeimat / 3);

        int gastTore = 0;
        for (int a = 0; a <= 3; a++)
            gastTore += random.nextInt(6);

        gastTore -= 3;
        gastTore = Math.round(gastTore / 3);

        this.toreGast = gastTore;
        this.toreHeim = summeHeimat;
    }


    public String spielStand() {
        return toreHeim + " : " + toreGast;
    }

    @Override
    public String toString() {
        return heimVerein.getName() + " : " + gastVerein.getName();
    }
}

