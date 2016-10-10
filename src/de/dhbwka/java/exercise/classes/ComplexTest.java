package de.dhbwka.java.exercise.classes;

import de.dhbwka.java.exercise.arrays.BubbleSortComplex;

import java.util.Random;

/**
 * Created by cem on 14.02.16.
 */
public class ComplexTest {

    public static void main(String[] args) {
        Complex complex = new Complex(1, 2);
        Complex complex1 = new Complex(2, 1);
        System.out.println("c1: " + complex.toString() + " betrag: " + complex.getMagnitude());
        System.out.println("c2: " + complex1.toString() + " betrag: " + complex1.getMagnitude());
        System.out.println("c = c1 + c2: " + complex.add(complex1).toString());
        System.out.println("c = c1 - c2: " + complex.sub(complex1).toString());
        System.out.println("c = c1 * c2: " + complex.mult(complex1).toString());
        System.out.println("c = c1 / c2: " + complex.div(complex1).toString());
        System.out.println("c1 < c2: " + complex1.isLess(complex));

        Random random = new Random();
        Complex[] complices = new Complex[10];
        for (int i = 0; i < complices.length; i++) {
            complices[i] = new Complex((double) random.nextInt(1000) / 100, (double) random.nextInt(1000) / 100);
        }
        System.out.println("Unsortiert: ");
        printArray(complices);
        System.out.println("Sortiert: ");
        printArray(BubbleSortComplex.bubbleShort(complices));

    }

    private static void printArray(Complex[] complices) {
        for (Complex complex : complices) {
            System.out.println(complex.toString());
        }
    }
}
