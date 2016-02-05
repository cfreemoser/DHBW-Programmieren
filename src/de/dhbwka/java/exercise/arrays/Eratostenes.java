package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

/**
 * Created by cem on 01.02.16.
 */
public class Eratostenes {
    public static void main(String[] args) {
        System.out.print("Bitte Zahl eingeben: ");
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        Integer[] sieve = new Integer[n - 2];

        for (int i = 0; i < n - 2; i++) {
            sieve[i] = i + 2;
        }
        int[] primes = new int[0];
        while (sieve.length > 0) {
            //suche kleinste zahl
            int min = sieve[0];
            for (int value : sieve) {
                if (value < min) min = value;
            }

            int[] temp = primes;
            primes = new int[primes.length + 1];
            for (int i = 0; i < primes.length; i++) {
                if (i == primes.length - 1) {
                    primes[primes.length - 1] = min;
                    continue;
                } else {
                    primes[i] = temp[i];
                }
            }

            int nullCount = 0;
            for (int i = 0; i < sieve.length; i++) {
                if (min != 0 && sieve[i] % min == 0) {
                    nullCount++;
                    sieve[i] = null;
                }
            }
            Integer[] tempo = sieve.clone();
            sieve = new Integer[sieve.length - nullCount];
            int index = 0;
            for (Integer tempooo : tempo) {
                if (tempooo != null) {
                    sieve[index] = tempooo;
                    index++;
                }
            }


        }

        for (int prim : primes) {
            System.out.print(prim + " ");
        }
        System.out.println();
        main(null);
    }
}
