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
        return horner(polynome, x, 0);
    }

    double horner(double a[], double x, int n) {
        double h;
        if (n < polynome.length - 1)
            h = horner(a, x, n + 1);
        else
            return a[n];

        return h * x + a[n];
    }


    @Override
    public String toString() {
        if (polynome.length > 0) {
            DecimalFormat fmt = new DecimalFormat("+(#,##0.0);-(#,##0.0)");
            String polynom = "";
            for (int i = polynome.length - 1; i > 0; i--) {
                double temp = polynome[i];
                if (temp != 0) {
                    polynom += fmt.format(temp) + "x^" + i;
                }
            }
            if (polynome[0] > 0) polynom += fmt.format(polynome[0]);
            return polynom;
        } else return "";
    }

}
