package de.dhbwka.java.klausurn.qUP;

/**
 * Created by cem on 12.10.16.
 */
public class Starter {
    public static void main(String[] args) {
        WaitingQuene quene = new WaitingQuene();

        for (int i = 0; i < 5; i++)
            System.out.println(quene.getNextQueneNumber());
        new DeskApp(quene, "Sachberareitung 1", "E201", "Max Muster");
        new DeskApp(quene, "Sachbearbeitung 2", "A301", "Britney Bitch");
        new DeskApp(quene, "Information", "Eingangsbereich", "Leon der Profi");
        new QueneDisplay(quene);
        new QueneDisplay(quene);
    }
}
