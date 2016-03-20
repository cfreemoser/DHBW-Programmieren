package de.dhbwka.java.exercise.periodic;

/**
 * Created by cem on 07.03.16.
 */
public class Metal extends Element {
    public boolean metalloid;
    public double conductivity;


    public Metal(String name, String symbol, int ordinal, char shell, int phase, boolean mainGroup, boolean metalloid, double conductivity) {
        super(name, symbol, ordinal, shell, phase, mainGroup);
        this.metalloid = metalloid;
        this.conductivity = conductivity;
    }

    public boolean isMetalloid() {
        return metalloid;
    }

    public void setMetalloid(boolean metalloid) {
        this.metalloid = metalloid;
    }

    public double getConductivity() {
        return conductivity;
    }

    public void setConductivity(double conductivity) {
        this.conductivity = conductivity;
    }

    private String metalloidToString() {
        return isMetalloid() ? "Halbleiter" : "";
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(super.toString());
        return stringBuffer.append(metalloidToString()).append(" \u03C3:")
                .append(conductivity).toString();
    }
}
