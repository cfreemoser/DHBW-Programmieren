package de.dhbwka.java.exercise.ui;

import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by cem on 02.06.16.
 */
public class EditorTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        EditorBar bar = new EditorBar();


        frame.setJMenuBar(bar);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);

    }
}
