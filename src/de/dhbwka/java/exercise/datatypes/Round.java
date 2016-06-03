package de.dhbwka.java.exercise.datatypes;

import java.util.Random;


/**
 * Created by cem on 25.01.16. hello
 */
public class Round {

    public static void main (String [] agrs) {
        double pi = 3.1415926; // Naeherung der Kreiszahl Pi
        double e = -2.7182818; // Naeherung der Eulerschen Zahl e

        System.out.println("Pi ganzzahlig: " + myRound(pi)); // Ausgabe: 3
        System.out.println("e ganzzahlig: " + myRound(e)); // Ausgabe: 2

        Random myRandom = new Random();
        for (int i = 0; i < 1000; i++) {
            double temp = myRandom.nextDouble();
            if (myRandom.nextInt(100) > 50) temp = -temp;
            System.out.println(temp + " => " + Math.round(temp) + " => " + myRound(temp));


        }
    }

    public static int myRound(double value) {
        /*
        if (value > 0) {
            double dif = value - (int) value;
            if (dif >= 0.5) {
                return (int) value + 1;
            } else {
                return (int) value;
            }
        }
        else {
            double dif = value + (int) value;
            if (dif <= 0.5) {
                return (int) value - 1;
            } else {
                return (int) value;
            }
        }
        */
        if (value > 0) return (int) (value + 0.5);
        else return (int) (value - 0.5);
    }


}
