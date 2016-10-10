package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

/**
 * Created by cem on 05.02.16.
 */
public class DotProduct {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);


        System.out.println("Wie viele Stellen?");
        int stellen = myScanner.nextInt();
        int[] vektor1 = new int[stellen];
        for (int i = 0; i < stellen; i++) {
            System.out.print("Vektor_1 " + (i + 1) + ". Wert ");
            vektor1[i] = myScanner.nextInt();
        }
        int[] vektor2 = new int[stellen];
        for (int i = 0; i < stellen; i++) {
            System.out.print("Vektor_2 " + (i + 1) + ". Wert ");
            vektor2[i] = myScanner.nextInt();
        }

        int skalar = 0;
        for (int i = 0; i < stellen; i++) {
            skalar += vektor1[i] * vektor2[i];
        }

        System.out.println("Ergebnis: " + skalar);
        System.out.println("");
        main(null);

    }

}
