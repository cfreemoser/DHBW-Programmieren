package de.dhbwka.java.exercise.classes;

import java.text.DecimalFormat;

/**
 * Created by cem on 13.02.16.
 */
public class Polynomial {
    private final double a;
    private final double b;
    private final double c;

    public Polynomial(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }


    public double f(double x) {
        return (a * x * x + b * x + c);
    }

    public Polynomial addiere(Polynomial polynomial) {
        return new Polynomial(a + polynomial.getA(), b + polynomial.getB(), c + polynomial.getC());
    }

    public Polynomial subtrahiere(Polynomial polynomial) {
        return new Polynomial(a - polynomial.getA(), b - polynomial.getB(), c - polynomial.getC());
    }

    public Polynomial skalarMultiplikation(double skalar) {
        return new Polynomial(a * skalar, b * skalar, c * skalar);
    }

    public double[] berechneNullstellen() {
        double diskriminante = (b * b - 4 * a * c);
        if (diskriminante < 0) return new double[]{};
        else if (diskriminante == 0) return new double[]{((-b) / (2 * a))};
        else return new double[]{(-b + Math.sqrt(diskriminante)) / (2 * a), (-b - Math.sqrt(diskriminante)) / (2 * a)};
    }

    @Override
    public String toString() {
        DecimalFormat fmt = new DecimalFormat("+#,##0.00;-#");
        return a + "x^2 " + fmt.format(b) + "x" + fmt.format(c);
    }
}
