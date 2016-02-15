package de.dhbwka.java.exercise.classes;


import java.util.Arrays;

/**
 * Created by cem on 13.02.16.
 */
public class PolynomialTest {
    public static void main(String[] args) {
        Polynomial polynomial = new Polynomial(1, 1, 1);
        System.out.println("[1] -> " + polynomial.toString() + " Nullstellen: " + Arrays.toString(polynomial.berechneNullstellen()));
        Polynomial polynomial2 = new Polynomial(1, 1, 0);
        System.out.println("[2] -> " + polynomial2.toString() + " Nullstellen: " + Arrays.toString(polynomial2.berechneNullstellen()));
        Polynomial polynomial3 = new Polynomial(1, 0, 0);
        System.out.println("[3] -> " + polynomial3.toString() + " Nullstellen: " + Arrays.toString(polynomial3.berechneNullstellen()));
        System.out.println("[1+2] -> " + polynomial.addiere(polynomial2).toString());
        System.out.println("[3-2] -> " + polynomial3.subtrahiere(polynomial2).toString());
        System.out.println("[3*10] -> " + polynomial3.skalarMultiplikation(10).toString());

    }
}
