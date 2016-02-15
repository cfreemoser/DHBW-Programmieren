package de.dhbwka.java.exercise.classes;

import java.util.Scanner;

/**
 * Created by cem on 14.02.16.
 */
public class HornerTest {
    public static void main(String[] args) {
//        double[] values = new double[]{1, 2, 3, 4.5, 8, -10, 3, 4, 2, -3, 0.5};
//        Horner horner = new Horner(values);
//        System.out.println(horner.toString());
//        System.out.println(horner.getValue(1.5));

        Scanner myScanner = new Scanner(System.in);
        System.out.print("Welchen Grad? ");
        int grad = myScanner.nextInt() + 1;
        double[] array = new double[grad];
        for (int i = 0; i < grad; i++) {
            if (i != 0) {
                System.out.print((i) + ". Grad:");
                array[i] = myScanner.nextDouble();
            } else {
                System.out.print("dein c ist was?");
                array[i] = myScanner.nextDouble();
            }
        }
        Horner horner = new Horner(array);
        System.out.println(horner);
        System.out.print("Funktionswert: ");
        System.out.println(horner.getValue(myScanner.nextDouble()));
        System.out.println();

        main(null);

    }
}
