package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

/**
 * Created by cem on 22.02.16.
 */
public class RomanNumber {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String myString = myScanner.nextLine();

        char[] chars = myString.toCharArray();

        System.out.println(covert(chars, 0));

        main(null);
    }

    private static int covert(char[] chars, int sum) {
        if (chars.length == 0) return sum;
        else if (chars.length >= 2 && isLess(chars[0], chars[1]))
            return covert(drop(chars, 2), (sum + (romToArabic(chars[1]) - romToArabic(chars[0]))));
        else return covert(drop(chars, 1), sum + romToArabic(chars[0]));
    }


    private static char[] drop(char[] chars, int cut) {
        if (chars.length == cut || chars.length < cut) {
            return new char[]{};
        } else {
            char[] droppedCharArray = new char[chars.length - cut];
            int a = 0;
            for (int i = cut; i < chars.length; i++) {
                droppedCharArray[a] = chars[i];
                a++;
            }
            return droppedCharArray;
        }
    }

    private static boolean isLess(char romanNumber1, char romanNumber2) {
        return romToArabic(romanNumber1) < romToArabic(romanNumber2);
    }

    private static int romToArabic(char romanNumber) {
        switch (romanNumber) {
            case 77:
                return 1000;
            case 68:
                return 500;
            case 67:
                return 100;
            case 76:
                return 50;
            case 88:
                return 10;
            case 86:
                return 5;
            case 73:
                return 1;
            default:
                return 0;
        }
    }
}
