package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

/**
 * Created by cem on 05.02.16.
 */
public class Nrcm {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Wie viele Stellen?");
        int stellen = myScanner.nextInt();
        int[] werte = new int[stellen];
        for (int i = 0; i < stellen; i++) {
            System.out.print(i + 1 + ". wert ");
            werte[i] = myScanner.nextInt();
        }
        int summe = 0;
        for (int wert : werte) {
            summe += wert;
        }
        double result = Math.sqrt(summe);
        System.out.println("Das ergebnis lautet " + result);
        System.out.println("");
        main(null);
    }
}
