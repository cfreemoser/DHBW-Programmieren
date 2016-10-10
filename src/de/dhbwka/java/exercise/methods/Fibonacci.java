package de.dhbwka.java.exercise.methods;

/**
 * Created by cem on 29.02.16.
 */
public class Fibonacci {


    public static int[] fibArray(int n) {
        long start = System.currentTimeMillis();
        int[] array = new int[n];
        for (int i = 1; i < n + 1; i++)
            array[i - 1] = fib(i);

        return array;
    }

    public static int fib(int n) {
        if (n > 1) return fib(n - 1) + fib(n - 2);
        else return n;
    }
}
