package de.dhbwka.java.exercise.classes;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by cem on 14.02.16.
 */
public class MasterMind {

    private static final String[] BUCHSTABEN = new String[]{"A", "B", "C", "D", "E", "H"};
    private final String loesung;
    private String temoLoesung;

    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private String[] versuche;

    public MasterMind(int leben) {
        versuche = new String[leben];

        String temp = "";
        for (int i = 0; i < 5; i++)
            temp += BUCHSTABEN[random.nextInt(BUCHSTABEN.length - 1)];
        loesung = temp;
        temoLoesung = loesung;

        game(leben, 0);
    }

    public void game(int leben, int versuch) {
        String tipp = getUserTipp().toUpperCase();
        if (leben == 0) System.out.println("gg easy noobs! ->" + loesung);
        else if (tipp.equals(loesung)) System.out.println("GG");
        else {
            StringBuilder builder = new StringBuilder();
            int richtig[] = zaeleRichtigeStellen(tipp);
            if (versuch > 0) {
                builder.append(versuch).append(" bieshierge Versuche").append("\n");
                for (int i = 0; i < versuch; i++) builder.append(versuche[i]).append("\n");
            }

            String temp = tipp.toUpperCase() + " " + richtig[0] + " " + (Math.abs(richtig[1] - richtig[0]));
            versuche[versuch] = temp;
            builder.append(temp).append("\n");
            System.out.println(builder.toString());
            game(leben - 1, versuch + 1);
        }

    }

    private int[] zaeleRichtigeStellen(String tipp) {
        int count[] = new int[]{0, 0};
        for (int i = 0; i < tipp.length(); i++) {
            if (containsChar(temoLoesung, tipp.charAt(i))) count[0] += 1;
            {
                if (tipp.charAt(i) == temoLoesung.charAt(i)) count[1] += 1;
                temoLoesung = loesung.replace(Character.toString(tipp.charAt(i)), "x");
            }


        }

        return count;
    }

    public boolean containsChar(String s, char search) {
        if (s.length() == 0)
            return false;
        else
            return s.charAt(0) == search || containsChar(s.substring(1), search);
    }


    private String getUserTipp() {
        System.out.print("Geben Sie ihren Tipp ab:");
        return scanner.next();
    }
}
