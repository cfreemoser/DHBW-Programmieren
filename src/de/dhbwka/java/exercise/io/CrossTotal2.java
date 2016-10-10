package de.dhbwka.java.exercise.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by cem on 22.02.16.
 */
public class CrossTotal2 {

    public static void main(String[] args) {
        if (args[0] != null) {
            Scanner myScanner = new Scanner(System.in);
            StringBuffer stringBuffer = new StringBuffer(myScanner.next());
            int sum = 0;
            for (int i = 0; i < stringBuffer.length(); i++)
                sum += Integer.parseInt(Character.toString(stringBuffer.charAt(i)));


            File file = new File(args[0], "crosstotals.txt");

            String result = "Quersumme von " + stringBuffer.toString() + " ist " + sum + "\n";
            writeToFile(file, result);

            main(args);
        }
    }


    public static void writeToFile(File file, String result) {
        if (result != null) {
            try {
                if (!file.exists())
                    file.createNewFile();

                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, true));
                bufferedOutputStream.write(result.getBytes());
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
