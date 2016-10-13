package de.dhbwka.java.klausurn.totoSpiel;

/**
 * Created by cem on 13.10.16.
 */
public class Starter {

    public static void main(String[] args) {
        Totalisator totalisator = new Totalisator("FFuck");
        totalisator.addParrung(new Paarung(new Verein("FC Bayern"), new Verein("S04")));
        totalisator.addParrung(new Paarung(new Verein("BVB"), new Verein("FC Köln")));
        totalisator.addParrung(new Paarung(new Verein("FC Karlsruhe"), new Verein("FC Stuttgart")));
        totalisator.addTipper(new Tipper("Henne", "Jan", totalisator));
        totalisator.addTipper(new Tipper("Britney", "Bicht", totalisator));


    }
}
