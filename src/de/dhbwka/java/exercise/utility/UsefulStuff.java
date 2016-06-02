package de.dhbwka.java.exercise.utility;

import java.io.*;

/**
 * Created by cem on 19.05.16.
 */
public class UsefulStuff {

    public static String appendNewLine(String line) {
        return line + System.lineSeparator();
    }

    /**
     * reads a complete file
     *
     * @param file the file to read
     * @return a String with the content of the file
     */
    public static String readTextFromFile(File file) {
        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
            fileInputStream = null;
        }

        InputStream inputStream = fileInputStream == null ? System.in : fileInputStream;
        StringBuilder builder = new StringBuilder("");

        if (inputStream != System.in) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            reader.lines().map(UsefulStuff::appendNewLine).forEach(builder::append);
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else builder.append("Oh Henne, das hat leider nicht geklappt");


        return builder.toString();
    }


}
