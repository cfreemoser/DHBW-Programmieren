package de.dhbwka.java.exercise.control;

/**
 * Created by cfreimoser on 18.01.16.
 */
public class Deers {


    public static void main(String[] args) {
        int deers = 200;
        int year = 0;
        while (deers < 300) {
            ++year;
            deers = (int) (Math.round(deers * 1.1) - 15);
        }
        System.out.println(year + " " + deers);
    }


}

