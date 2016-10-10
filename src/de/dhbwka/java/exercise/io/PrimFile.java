package de.dhbwka.java.exercise.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by cem on 20.03.16.
 */
public class PrimFile {
    public static void main(String[] args) throws IOException {
        File primFile = new File(args[0]);
        FileReader myFileReader = new FileReader(primFile);
        BufferedReader bufferedReader = new BufferedReader(myFileReader);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Deine Zahl: ");
        int guess = scanner.nextInt();
        if (bufferedReader.lines().anyMatch(a -> a.equals(String.valueOf(guess))))
            System.out.println(guess + " ist eine Primzahl");
        else System.out.println(guess + " ist keine Primzahl");

        myFileReader.close();
        bufferedReader.close();

        main(new String[]{"/home/cem/Dokumente/DHBW/Programmieren/IO/prim"});
    }
}
