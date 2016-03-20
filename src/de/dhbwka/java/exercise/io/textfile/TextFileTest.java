package de.dhbwka.java.exercise.io.textfile;

import java.io.File;
import java.util.Arrays;

/**
 * Created by cem on 20.03.16.
 */
public class TextFileTest {

    public static void main(String[] args) {
        try {
            TextFile textFile = new TextFile(new File(args[0]));
            System.out.println(Arrays.toString(textFile.getLines()));
            System.out.println(textFile.availableLines());
            textFile.setLine(3, "cem cem cem cem cem");
            System.out.println(Arrays.toString(textFile.getLines()));
            textFile.replaceAll("meine", "unsre");
            textFile.close();


        } catch (Exception e) {
            System.out.println("line16");

            e.printStackTrace();
        }
    }
}
