package de.dhbwka.java.exercise.classes;

/**
 * Created by cem on 14.02.16.
 */
public class HornerTest {
    public static void main(String[] args) {
        double[] values = new double[]{1, 2, 3, 4.5, 8, -10, 3, 4, 2, -3, 0.5};
        Horner horner = new Horner(values);
        System.out.println(horner.toString());
        System.out.println(horner.getValue(1.5));

    }
}
