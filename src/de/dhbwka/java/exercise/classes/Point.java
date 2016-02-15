package de.dhbwka.java.exercise.classes;

/**
 * Created by cem on 13.02.16.
 */
public class Point {
    private double x;
    private double y;


    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point spiegelX() {
        return new Point(-x, y);
    }

    public Point spiegelY() {
        return new Point(x, -y);
    }

    public Point spiegel() {
        return this.spiegelX().spiegelY();
    }

    public double abstand() {
        return abstand(new Point(0, 0));
    }

    public double abstand(Point p2) {
        return Math.sqrt(Math.pow(this.getX() - p2.getX(), 2) + Math.pow(this.getY() - p2.getY(), 2));
    }

    @Override
    public String toString() {
        return "(" + String.valueOf(x) + ", " + String.valueOf(y) + ")";
    }

}
