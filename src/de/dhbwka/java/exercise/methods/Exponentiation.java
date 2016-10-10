package de.dhbwka.java.exercise.methods;

/**
 * Created by cem on 29.02.16.
 */
public class Exponentiation {

    public static float xPowerN(float bais, int expo) {
        if (expo == 0) return 1;
        else return bais * xPowerN(bais, expo - 1);
    }
}
