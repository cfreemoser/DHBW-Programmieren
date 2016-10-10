package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

/**
 * Created by cem on 08.02.16.
 */
public class Pascal {
    public static void main(String[] args) {
        System.out.print("Anzahl: ");
        Scanner myScanner = new Scanner(System.in);
        int anzahl = myScanner.nextInt();


        int pascal[][] = new int[anzahl][];


        pascal[0] = new int[]{1};
        pascal[1] = new int[]{1, 1};
        pascal[2] = new int[]{1, 2, 1};
        for (int i = 3; i < anzahl; i++) {
            int length = pascal[i - 1].length + 1;

            int[] fillIn = new int[length];
            fillIn[0] = 1;
            fillIn[length - 1] = 1;

            int[] before = pascal[i - 1];

            if (before.length > 1) {
                for (int j = 1; j < length - 1; j++) {
                    int summe = before[j - 1] + before[j];
                    fillIn[j] = summe;

                }
            }
            pascal[i] = fillIn;
        }


        printArray(pascal);

    }


    private static void printArray(int[][] myarray) {
        for (int[] array : myarray) {
            for (int value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }


}
