package de.dhbwka.java.exercise.datatypes;

/**
 * Created by cem on 25.01.16.
 */
public class ShortValue {

    public static void main(String[] args) {

        /**
         * -2^7 |   2^6 |   2^5 |   2^4 |   2^3 |   2^2 |   2^1 |   2^0
         * -128 |    64 |  32   |   16  |   8   |   4   |    2  |    1
         * --------------------------------------------------------------
         *   0  |   0   | 1     |  0    |    1  |   0   |    1  |    0         <= 42
         *   1  |   1   | 0     |  1    |    0  |   1   |    0  |    1         <= -43
         *   0  |   0   | 0     |  0    |    0  |   0   |    0  |    1         <= +1
         * --------------------------------------------------------------
         *   1  |   1   | 0     |  1    |    0  |   1   |    1  |    0         <= -42
         */
        short value = 32767;
        System.out.println(value);
        //es folgt die überschreitung des bereiches, also negative beginn
        value++;
        System.out.println(value);

    }
}
