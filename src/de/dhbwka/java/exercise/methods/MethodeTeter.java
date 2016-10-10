package de.dhbwka.java.exercise.methods;

/**
 * Created by cem on 29.02.16.
 */
public class MethodeTeter {

    public static void main(String[] args) {
//        System.out.println("__________Exponentiation_____");
//        System.out.println(Exponentiation.xPowerN(5,2));


//        System.out.println("__________Fibonacci!!!________");
//        System.out.println(Arrays.toString(Fibonacci.fibArray(50)));

        long start = System.currentTimeMillis();
        for (int i = 1; i < 50; i++)
            System.out.println(Fibonacci.fib(i));

        System.out.println("needed time: " + (System.currentTimeMillis() - start) + "ms");
    }
}
