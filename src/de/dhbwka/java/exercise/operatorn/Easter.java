package de.dhbwka.java.exercise.operatorn;

import de.dhbwka.java.exercise.utility.Tuple;
import javafx.util.Pair;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by cfreimoser on 18.01.16.
 */
public class Easter {

    private final  static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");

    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a Year");
        System.out.println("easter is on " + makeDate(calculateEaster(myScanner.nextInt())));

    }

    private static Tuple<Double, Integer> calculateEaster(int year) {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int k = year / 100;
        int p = (8 * k + 13) / 25;
        int q = k / 4;
        int m = (15 + k - p - q) / 30;
        int n = (4 + k - q) / 7;
        int d = (19*a + m) % 30;
        double e = (2* b + 4 *c + 6d + n) % 7;
        return new Tuple<>(22 + d + e, year);
    }

    private static String makeDate(Tuple<Double, Integer> tuple) {
       LocalDate date = LocalDate.of(tuple.y, Month.MARCH, 1).plusDays(Math.round(tuple.x));
        return date.format(formatter);
    }
}
