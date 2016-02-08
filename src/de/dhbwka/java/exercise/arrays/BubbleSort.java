package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by cem on 05.02.16. Eigentlich hab ich das erstellt (cemig) 
 */
public class BubbleSort {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Hallöchen, wie viele Zahlen soll ich sortieren? ");
        int[] zahlen = new int[myScanner.nextInt()];
        for (int i = 0; i < zahlen.length; i++) {
            System.out.print((i + 1) + ". Zahl: ");
            zahlen[i] = myScanner.nextInt();
        }

        System.out.print(Arrays.toString(zahlen));
        while (!isShorted(zahlen)) {

            for (int i = 0; i < zahlen.length; i++) {
                if ((i + 1) <= zahlen.length - 1 && zahlen[i] > zahlen[i + 1]) {
                    int temp = zahlen[i];
                    zahlen[i] = zahlen[i + 1];
                    zahlen[i + 1] = temp;
                }

            }

            System.out.print(" -> " + Arrays.toString(zahlen));
        }


    }

    public static boolean isShorted(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if ((i + 1) <= array.length - 1 && array[i] > array[i + 1]) return false;
        }
        return true;
    }
}
