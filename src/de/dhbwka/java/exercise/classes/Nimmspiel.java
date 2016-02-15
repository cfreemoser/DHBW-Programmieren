package de.dhbwka.java.exercise.classes;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by cem on 14.02.16.
 */
public class Nimmspiel {

    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private String[] spieler;
    private int[] haufen;


    public Nimmspiel(String[] spieler) {
        this.haufen = new int[]{random.nextInt(369), random.nextInt(369)};
        this.spieler = spieler;
    }

    public boolean nimmKugel(int index, int amount) {
        if (index < haufen.length && amount > 0 && amount < haufen[index]) {
            haufen[index] -= amount;
            return true;
        } else {
            return false;
        }
    }

    public String getPlayer(int index) {
        return spieler[index];
    }

    public boolean isOver() {
        return haufen[0] == 0 || haufen[1] == 0;
    }

    @Override
    public String toString() {
        return "Haufen 1: " + haufen[0] + " || Haufen 2: " + haufen[1];
    }


}
