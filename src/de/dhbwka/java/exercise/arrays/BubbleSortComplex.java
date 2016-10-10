package de.dhbwka.java.exercise.arrays;

import de.dhbwka.java.exercise.classes.Complex;

/**
 * Created by cem on 05.02.16. Eigentlich hab ich das erstellt (cemig) <- nö
 */
public class BubbleSortComplex {


    public static Complex[] bubbleShort(Complex[] zahlen) {
        while (!isShorted(zahlen)) {

            for (int i = 0; i < zahlen.length; i++) {
                if ((i + 1) <= zahlen.length - 1 && zahlen[i + 1].isLess(zahlen[i])) {
                    Complex temp = zahlen[i];
                    zahlen[i] = zahlen[i + 1];
                    zahlen[i + 1] = temp;
                }

            }

        }
        return zahlen;
    }

    public static boolean isShorted(Complex[] array) {
        for (int i = 0; i < array.length; i++) {
            if ((i + 1) <= array.length - 1 && !array[i].isLess(array[i + 1])) return false;
        }
        return true;
    }
}
