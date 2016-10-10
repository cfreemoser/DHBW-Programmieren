package de.dhbwka.java.exercise.classes;

import java.util.Scanner;

/**
 * Created by cem on 14.02.16.
 */
public class NimmSpielControll {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wie viele Spieler? ");
        int countPlayers = scanner.nextInt();
        String[] players = new String[countPlayers];
        for (int i = 0; i < countPlayers; i++) {
            System.out.println("Spieler " + (i + 1) + " Wie ist dein Name?");
            players[i] = scanner.next();
        }

        Nimmspiel nimmspiel = new Nimmspiel(players);
        System.out.println(nimmspiel.toString());
        int currentPlayer = 0;
        while (!nimmspiel.isOver()) {
            System.out.println(nimmspiel.getPlayer(currentPlayer) + " von wo möchtest du abheben?");
            int haufen = scanner.nextInt();
            System.out.println(nimmspiel.getPlayer(currentPlayer) + " wie viel möchtest du abheben?");
            int amount = scanner.nextInt();
            if (nimmspiel.nimmKugel(haufen - 1, amount)) {
                if (currentPlayer < players.length - 1) currentPlayer++;
                else currentPlayer = 0;
            }

            System.out.println(nimmspiel.toString());
        }

    }
}
