package de.dhbwka.java.exercise.threads;

import java.awt.*;
import java.util.Random;

/**
 * Created by cem on 04.07.16.
 */
public class Line {
    private final Point startPoint;
    private final Point endPoint;
    private final Color lineColor;
    private final int thinkness;

    public Line(Point startPoint, Point endPoint, Color lineColor, int thinkness) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.lineColor = lineColor;
        this.thinkness = thinkness;
    }

    public Line scaleLine(int move) {
        if (Math.random() < 0.5)
            return new Line(new Point(endPoint.getX() - move, endPoint.getY() - move), new Point(startPoint.getX() - move, startPoint.getY() - move), lineColor, thinkness);
        else
            return new Line(new Point(endPoint.getX() + move, endPoint.getY() + move), new Point(startPoint.getX() + move, startPoint.getY() + move), lineColor, thinkness);
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public Line mutateColor() {
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 2:
                return new Line(startPoint, endPoint, Color.blue, thinkness);
            case 3:
                return new Line(startPoint, endPoint, Color.cyan, thinkness);
            case 4:
                return new Line(startPoint, endPoint, Color.darkGray, thinkness);
            default:
                return new Line(startPoint, endPoint, Color.BLACK, thinkness);
        }

    }

    public Line mutateThinkness() {
        Random random = new Random();
        if (Math.random() > 0.5)
            return new Line(startPoint, endPoint, lineColor, thinkness - random.nextInt(1));
        else return new Line(startPoint, endPoint, lineColor, thinkness + random.nextInt(2));
    }

    public Line mutateLine(int factor) {
        return mutateThinkness().mutateColor();
    }

    public int getThinkness() {
        return thinkness;
    }
}
