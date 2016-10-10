package de.dhbwka.java.exercise.classes;

/**
 * Created by cem on 13.02.16.
 */
public class PointTest {
    public static void main(String[] args) {
        System.out.print("Erstelle Punkt: ");
        Point point = new Point(2, 2);
        System.out.println(point.toString());
        System.out.println("Abstand zum Ursrpung " + point.abstand());
        System.out.print("Spiegel punkt an X-Achste: ");
        System.out.println(point.spiegelX());
        System.out.print("Spiegel punkt an Y-Achste: ");
        System.out.println(point.spiegelY());
        System.out.print("Spiegel punkt am Ursprung: ");
        System.out.println(point.spiegel());
        System.out.print("Erstelle zweiten Punkt: ");
        Point point2 = new Point(-7, -8);
        System.out.println(point2);
        System.out.println("Abstand zwischen den Punkten " + point.abstand(point2));

    }
}