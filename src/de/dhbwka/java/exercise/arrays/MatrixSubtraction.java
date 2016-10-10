package de.dhbwka.java.exercise.arrays;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by cem on 08.02.16.
 */
public class MatrixSubtraction {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("n: ");
        int n = myScanner.nextInt();
        System.out.print("m: ");
        int m = myScanner.nextInt();

        int[][] x = new int[n][m];
        int[][] y = new int[n][m];

        fillArray(x);
        fillArray(y);

        int[][] resultArray = subtract(x, y);

        System.out.println("X:");
        printArray(x);
        System.out.println("Y:");
        printArray(y);
        System.out.println("X-Y:");
        printArray(resultArray);

    }

    private static int[][] subtract(int[][] x, int[][] y) {
        int[][] result = new int[x[0].length][x[1].length];
        for (int i = 0; i < result[0].length; i++) {
            for (int j = 0; j < result[1].length; j++) {
                result[i][j] = x[i][j] - y[i][j];
            }
        }
        return result;
    }

    private static void fillArray(int[][] myarray) {
        Random myRandom = new Random();
        for (int i = 0; i < myarray[0].length; i++) {
            for (int j = 0; j < myarray[1].length; j++) {
                myarray[i][j] = myRandom.nextInt(100);
            }
        }
    }

    private static void printArray(int[][] myarray) {
        for (int i = 0; i < myarray[0].length; i++) {
            for (int j = 0; j < myarray[1].length; j++) {
                System.out.print(myarray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
