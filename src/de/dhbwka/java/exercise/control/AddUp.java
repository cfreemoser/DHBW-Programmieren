package de.dhbwka.java.exercise.control;

import java.util.Scanner;

/**
 * Created by cem on 01.02.16.
 */
public class AddUp {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int wert = 0;
        int ergebnis = 0;
        while (wert >= 0) {
            ergebnis += wert;
            System.out.println("neu");
            wert = myScanner.nextInt();
        }
        System.out.println(ergebnis);
    }


}
