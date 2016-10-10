package de.dhbwka.java.exercise.classes;

import java.text.DecimalFormat;

/**
 * Created by cem on 13.02.16.
 */
public class Complex {
    private final double real;
    private final double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public Complex add(Complex complex) {
        return new Complex(this.real + complex.getReal(), this.imag + complex.getImag());
    }

    public Complex sub(Complex complex) {
        return new Complex(this.real - complex.getReal(), this.imag - complex.getImag());
    }

    public Complex mult(Complex complex) {
        double ac = this.real * complex.getReal();
        double bd = this.imag * complex.getImag();
        double ad = this.real * complex.getImag();
        double bc = this.imag * complex.getReal();
        return new Complex(ac - bd, ad + bc);
    }

    public Complex div(Complex complex) {
        double ac = this.real * complex.getReal();
        double bd = this.imag * complex.getImag();
        double c2 = complex.getReal() * complex.getReal();
        double d2 = complex.getImag() * complex.getImag();
        double bc = this.imag * complex.getReal();
        double ad = this.real * complex.getImag();
        return new Complex((ac + bd) / (c2 + d2), (bc - ad) / (c2 + d2));
    }

    public double getMagnitude() {
        return Math.sqrt(this.real * this.real + this.imag * this.imag);
    }

    public boolean isLess(Complex complex) {
        return this.getMagnitude() < complex.getMagnitude();
    }

    @Override
    public String toString() {
        DecimalFormat fmt = new DecimalFormat("+#,##0.0;-#");
        return String.valueOf(real).replace(".", ",") + fmt.format(imag) + "i" + "|| " + fmt.format(this.getMagnitude());
    }
}
