package de.dhbwka.java.exercise.periodic;

/**
 * Created by cem on 07.03.16.
 */
public class Element {
    public String name;
    public String symbol;
    public int ordinal;
    public char shell;
    public int phase;
    public boolean mainGroup;

    //alt + einf
    public Element(String name, String symbol, int ordinal, char shell, int phase, boolean mainGroup) {
        this.name = name;
        this.symbol = symbol;
        this.ordinal = ordinal;
        this.shell = shell;
        this.phase = phase;
        this.mainGroup = mainGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public char getShell() {
        return shell;
    }

    public void setShell(char shell) {
        this.shell = shell;
    }

    public double getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public boolean isMainGroup() {
        return mainGroup;
    }

    public void setMainGroup(boolean mainGroup) {
        this.mainGroup = mainGroup;
    }

    private String groupName() {
        return mainGroup ? "Hauptgruppe" : "Nebengrouppe";
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer("");
        return buffer.append(getClass().getSimpleName())
                .append("(").append(name).append(", ").append(ordinal)
                .append(") Schale: ").append(shell).append(", ").append(phase)
                .append(", group").append(groupName()).toString();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Element && ((Element) obj).getOrdinal() == this.shell;
    }
}
