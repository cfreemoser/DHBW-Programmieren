package de.dhbwka.java.exercise.arrays;

/**
 * Created by cem on 01.02.16.
 */
public class Fibonacci {
    public static void main(String[] args) {


        int[] fibcnacci = new int[1000];
        fibcnacci[0] = 1;
        fibcnacci[1] = 1;
        for (int i = 2; i < 1000; i++) {
            fibcnacci[i] = fibcnacci[i - 1] + fibcnacci[i - 2];
        }

        for (int value : fibcnacci) {
            System.out.print(value + ", ");
        }
    }
}
