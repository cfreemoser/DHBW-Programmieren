package de.dhbwka.java.exercise.classes;

import java.text.DecimalFormat;

/**
 * Created by cem on 14.02.16.
 */
public class Horner {

    private final double[] polynome;

    public Horner(double[] polynome) {
        this.polynome = polynome;
    }


    public double getValue(double x) {
        return hornerSchema(x, 0);
    }

    private double hornerSchema(double x, int n) {
        if (n >= polynome.length - 1) return polynome[n];
        else return hornerSchema(x, n + 1) * x + polynome[n];
    }


    @Override
    public String toString() {
        DecimalFormat fmt = new DecimalFormat("+(#,##0.0);-(#,##0.0)");
        StringBuilder builder = new StringBuilder("");
        if (polynome.length > 0) {
            for (int i = polynome.length - 1; i > 0; i--)
                if (polynome[i] != 0) builder.append(fmt.format(polynome[i])).append("x^").append(i);

            if (polynome[0] > 0) builder.append(polynome[0]);
        }
        return builder.toString();
    }

}

