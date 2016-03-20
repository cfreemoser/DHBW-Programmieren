package de.dhbwka.java.exercise.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by cem on 14.03.16.
 */
public class TextfileLines {

    public static void main(String[] args) throws IOException {
        if (args[0] != null) {
            File file = new File(args[0]);

            //Teilaufgabe 1
            Stream<String> stream = new BufferedReader(new FileReader(file)).lines();
            stream.skip(1).limit(4).forEach(System.out::println);
            stream.close();

            /**
             * man könnte auch reduce=fold verwenden hat aber aufwand O(n^2)
             * TODO googlen was fürn aufwand fold in scala hat bzw justin fragen
             *
             */
            stream = new BufferedReader(new FileReader(file)).lines();
            System.out.println("Zeile 2-5: " + stream.skip(1).limit(4).collect(Collectors.joining()));
            stream.close();
        }
    }
}
