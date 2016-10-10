package de.dhbwka.java.exercise.operatorn;

import de.dhbwka.java.exercise.utility.Tuple;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Created by cfreimoser on 18.01.16.
 */
public class Easter {

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM y");

    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("jahr eingeben");
        System.out.println("Ostern ist am " + makeDate(calculateEaster(myScanner.nextInt())) + "\n");
        main(null);
    }

    private static Tuple<Integer, Integer> calculateEaster(int year) {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int k = year / 100;
        int p = (8 * k + 13) / 25;
        int q = k / 4;
        int m = (15 + k - p - q) % 30;
        int n = (4 + k - q) % 7;
        int d = (19*a + m) % 30;
        int e = (2* b + 4 *c + 6*d + n) % 7;
        int easter = 22 + d + e;
        return new Tuple<>(easter, year);
    }

    private static String makeDate(Tuple<Integer, Integer> tuple) {
        LocalDate date = LocalDate.of(tuple.y, Month.MARCH, 1).plusDays(Math.round(tuple.x - 1));
        return date.format(formatter);
    }
}