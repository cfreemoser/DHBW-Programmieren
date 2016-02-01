package de.dhbwka.java.exercise.control;

import java.util.Scanner;

/**
 * Created by cem on 01.02.16.
 */
public class Babylon {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("wert eingeben");
        int temp = myScanner.nextInt();
        System.out.println(sqrt(temp));
        System.out.println();
        main(null);

    }

    public static double sqrt(double a) {
        return sqrtWorker(a, 25, 1);
    }

    private static double sqrtWorker(double a, double x, double x_1) {
        if (Math.abs(x_1 - x) < 10e-6) {
            return x;
        } else {
            return sqrtWorker(a, (x + (a / x)) / 2, x);
        }
    }
}
