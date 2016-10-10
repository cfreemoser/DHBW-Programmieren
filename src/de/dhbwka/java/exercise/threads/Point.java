package de.dhbwka.java.exercise.threads;

/**
 * Created by cem on 04.07.16.
 */
public class Point {

    final int x;

    final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point move(int x, int y) {
        return new Point(x, y);
    }
}
