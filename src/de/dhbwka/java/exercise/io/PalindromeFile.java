package de.dhbwka.java.exercise.io;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;

/**
 * Created by cem on 22.02.16.
 */
public class PalindromeFile {

    public static void main(String[] args) throws IOException {
        if (args.length > 0 && args[0] != null) {
            File file = new File(args[0], "palidrom.txt");
            if (!file.exists()) file.createNewFile();

            Optional<FileOutputStream> fileOutputStream = Optional.of(new FileOutputStream(file));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            PrintStream ps = (fileOutputStream.isPresent()) ? new PrintStream(fileOutputStream.get()) : System.out;
            Scanner myScanner = new Scanner(System.in);

            while (true) {
                StringBuffer input = new StringBuffer(myScanner.next());
                if (input.toString().equals("finish")) {
                    bufferedReader.lines().forEach(System.out::println);
                    break;
                } else if (input.toString().equalsIgnoreCase(input.reverse().toString()))
                    ps.println(input.toString());

            }

            bufferedReader.close();
            ps.close();


        }
    }


}
