package de.dhbwka.java.exercise.control;

/**
 * Created by cem on 01.02.16.
 */
public class MultiplicationTable {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            for (int a = 1; a <= 10; a++) {
                System.out.printf(" " + "%-3d", i * a);
            }
            System.out.println();
        }
    }
}
