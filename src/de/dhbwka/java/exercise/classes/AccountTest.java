package de.dhbwka.java.exercise.classes;

import java.util.Random;

/**
 * Created by cem on 13.02.16.
 */
public class AccountTest {
    public static void main(String[] args) {
        System.out.print("Erstelle Konto: ");
        Account account = new Account(1234546, "Cem Philipp Freimoser");
        System.out.println(account.toString());
        account.einzahlen(10);

        System.out.println("Einzahlen 10 " + account.toString());
        account.auszahlen(5);
        System.out.print("Auszahlen 5: " + account.toString());

        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int zufallsZahl2 = random.nextInt(1000);
            if (i % 2 == 0) {
                System.out.print(account.toString() + " -> ");
                account.einzahlen(zufallsZahl2);
                System.out.print("einzahlen [" + zufallsZahl2 + "] " + account.toString() + "\n");
            } else {
                System.out.print(account.toString() + " -> ");
                account.auszahlen(zufallsZahl2);
                System.out.print("auszahlen [" + zufallsZahl2 + "] " + account.toString() + "\n");
            }

        }


    }
}
