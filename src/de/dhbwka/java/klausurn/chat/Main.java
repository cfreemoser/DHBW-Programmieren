package de.dhbwka.java.klausurn.chat;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new ChatSession("cem");
        new ChatSession("serdar");
        new ChatSession("rico");

    }
}
