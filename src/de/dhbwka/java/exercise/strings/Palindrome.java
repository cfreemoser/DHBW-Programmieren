package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

/**
 * Created by cem on 22.02.16.
 */
public class Palindrome {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        StringBuffer input = new StringBuffer(myScanner.next());
        System.out.println(input.toString().equalsIgnoreCase(input.reverse().toString()));

        main(null);
    }
}
