package de.dhbwka.java.exercise.classes;

import de.dhbwka.java.exercise.arrays.BubbleSort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by cem on 14.02.16.
 */
public class Lotto {

    public final int anzahlAller;
    public final int anzahlZumZiehen;

    private int[] aAnwenderTipp;
    private int[] aGezogeneZahlen;
    private int[] aAlleKugeln;
    private boolean mGetippt = false;
    private boolean mGezogen = false;

    private Scanner myScanner = new Scanner(System.in);

    public Lotto(int m, int n) {
        this.anzahlAller = n;
        this.anzahlZumZiehen = m;
        this.aGezogeneZahlen = new int[anzahlZumZiehen];
        this.aAlleKugeln = new int[anzahlAller];
        this.aAnwenderTipp = new int[anzahlZumZiehen];

        for (int i = 1; i <= anzahlAller; i++)
            aAlleKugeln[i - 1] = i;
    }

    public void tippen() {
        System.out.println("Welche zahlen tippen sie?");
        for (int i = 0; i < aAnwenderTipp.length; i++) {
            System.out.print("Geben Sie bitte Ihren tipp für die " + (i + 1) + ". Zahl ein: ");
            aAnwenderTipp[i] = myScanner.nextInt();
            if (aAnwenderTipp[i] > anzahlAller) i--;
        }
        if (hasDuplicates(aAnwenderTipp)) {
            System.out.println("Sie können nicht zwei mal die gleiche Zahl haben");
            tippen();
        } else {
            mGetippt = true;
            BubbleSort.bubbleShort(aAnwenderTipp);
        }
    }

    public void tippen(int[] tipp) {
        if (this.aAnwenderTipp.length != tipp.length) return;
        this.aAnwenderTipp = tipp.clone();
        mGetippt = true;
        BubbleSort.bubbleShort(tipp);
    }

    public void ziehen() {
        mGezogen = true;
        Random random = new Random();
        for (int i = 0; i < aGezogeneZahlen.length; i++)
            aGezogeneZahlen[i] = aAlleKugeln[random.nextInt(aAlleKugeln.length - 1)];
        if (hasDuplicates(aGezogeneZahlen)) ziehen();
        else BubbleSort.bubbleShort(aAnwenderTipp);
    }

    private boolean hasDuplicates(int[] drawn) {
        for (int j = 0; j < drawn.length; j++)
            for (int k = j + 1; k < drawn.length; k++)
                if (k != j && drawn[k] == drawn[j])
                    return true;
        return false;
    }

    public int richtige() {
        int count = 0;
        for (int i = 0; i < aGezogeneZahlen.length; i++) {
            for (int j = 0; j < aGezogeneZahlen.length; j++) {
                if (aAnwenderTipp[i] == aGezogeneZahlen[j]) count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("");
        if (mGetippt) builder.append("Tipp: ").append(Arrays.toString(aAnwenderTipp)).append("\n");
        if (mGezogen) builder.append("Gezogene Zahlen: ").append(Arrays.toString(aGezogeneZahlen)).append("\n");
        if (mGetippt && mGezogen) builder.append("Richtige: ").append(richtige()).append("\n").append("\n");
        return builder.toString().replace("[", "").replace(",", " ").replace("]", "");
    }
}
