package de.dhbwka.java.exercise.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by cem on 01.02.16.
 */
public class EratostenesFile {
    public static void main(String[] args) {
        if (args[0] != null) {
            System.out.print("Bitte Zahl eingeben: ");
            Scanner myScanner = new Scanner(System.in);
            long n = myScanner.nextInt();
            Long[] sieve = new Long[(int) n - 2];

            for (int i = 0; i < n - 2; i++) {
                sieve[i] = (long) (i + 2);
            }
            Long[] primes = new Long[0];
            while (sieve.length > 0) {
                //suche kleinste zahl
                long min = sieve[0];
                for (long value : sieve) {
                    if (value < min) min = value;
                }

                Long[] temp = primes;
                primes = new Long[primes.length + 1];
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
                Long[] tempo = sieve.clone();
                sieve = new Long[sieve.length - nullCount];
                int index = 0;
                for (Long tempooo : tempo) {
                    if (tempooo != null) {
                        sieve[index] = tempooo;
                        index++;
                    }
                }


            }
            FileWriter writer = null;
            try {
                File file = new File(args[0], "prim");
                writer = new FileWriter(file);
                for (Long prim : primes) {
                    writer.append(String.valueOf(prim));
                    writer.append(System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException nl) {
                nl.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
