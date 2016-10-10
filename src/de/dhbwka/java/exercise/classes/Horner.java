package de.dhbwka.java.exercise.classes;

import java.text.DecimalFormat;

/**
 * Created by cem on 14.02.16.
 */
public class Horner {

    private final double[] koeff;

    public Horner(double[] koeff) {
        this.koeff = koeff;
    }

    public double getValue(double x) {
        return hornerSchema(x, 0);
    }

    private double hornerSchema(double x, int n) {
        if (n >= koeff.length - 1) return koeff[n];
        else return hornerSchema(x, n + 1) * x + koeff[n];
    }


    @Override
    public String toString() {
        DecimalFormat fmt = new DecimalFormat("+(#,##0.0);-(#,##0.0)");
        StringBuilder builder = new StringBuilder("");
        if (koeff.length > 0) {
            for (int i = koeff.length - 1; i > 0; i--)
                if (koeff[i] != 0) builder.append(fmt.format(koeff[i])).append("x^").append(i);

            if (koeff[0] > 0) builder.append(koeff[0]);
        }
        return builder.toString();
    }

}

