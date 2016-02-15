package de.dhbwka.java.exercise.arrays;

/**
 * Created by cem on 08.02.16.
 */
public class SiveMuster {

    public static void main(String[] args) {

        final int MAX = 100000;

        boolean[] sieve = new boolean[MAX];

        for (int i = 0; i < sieve.length; i++) {
            sieve[i] = true;
        }

        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]) {
                System.out.println(sieve[i]);
                for (int j = 2 * i; j < sieve.length; j += i) {
                    sieve[j] = false;
                }
            }
        }
    }


}
