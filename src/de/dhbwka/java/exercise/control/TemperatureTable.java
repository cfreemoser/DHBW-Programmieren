package de.dhbwka.java.exercise.control;

/**
 * Created by cfreimoser on 18.01.16.
 */
public class TemperatureTable {


    public static void main(String[] args) {
        /*
       Erstellen Sie ein Programm zur Ausgabe einer Temperaturtabelle von Fahrenheit (f) nach Celsius (c)!
       Die Tabelle soll bei 0° F beginnen und bei 300° F enden. Die Abstände der Stützstellen sollen 20° F
       betragen.
       Der funktionale Zusammenhang von c und f ist gegeben durch die Formel:
       c = (5 / 9) * ( f - 32)

         */

        System.out.println("Fahrenheit I Celsius");
        System.out.println("-----------+--------");
        for (int f = 0; f <= 300; f = f + 20) {
            int c = (5 / 9) * (f - 32);
            System.out.printf("%-3d -------+------ %-3d\n", f, c);

        }
    }


}

