package de.dhbwka.java.exercise.arrays;

import java.util.Random;

/**
 * Created by cem on 01.02.16.
 */
public class StandardDeviation {

    public static void main(String[] args) {
        int[] myArray = new int[100];
        Random myRandom = new Random();
        for (int i = 0; i < 100; i++) {
            myArray[i] = myRandom.nextInt(10);
        }

        double mittelwert = 0;
        for (int value : myArray) {
            mittelwert += value;
        }

        mittelwert = mittelwert / myArray.length;
        System.out.println("Mittelwert: " + mittelwert);

        double temp = 0;
        for (int value : myArray) {
            temp = temp + Math.pow((value - mittelwert), -2);
        }
        System.out.println(temp);
        double abweichnung = Math.sqrt((1.0 / (myArray.length - 1) * temp));
        System.out.println(abweichnung);

    }
}
