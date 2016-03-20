package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

/**
 * Created by cem on 22.02.16.
 */
public class CrossTotal {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        StringBuffer stringBuffer = new StringBuffer(myScanner.next());
        int sum = 0;
        for (int i = 0; i < stringBuffer.length(); i++)
            sum += Integer.parseInt(Character.toString(stringBuffer.charAt(i)));


        System.out.printf("Quersumme: " + (sum));

        main(null);
    }
}
