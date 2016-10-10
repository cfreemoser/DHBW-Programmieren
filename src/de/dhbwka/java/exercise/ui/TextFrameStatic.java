package de.dhbwka.java.exercise.ui;

import de.dhbwka.java.exercise.utility.UsefulStuff;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by cem on 02.06.16.
 */
public class TextFrameStatic extends JFrame {

    public TextFrameStatic(int frameWidth, int frameHeight, File file) {

        String[] lines = UsefulStuff.readTextFromFile(file).split(System.lineSeparator());

        this.setLayout(new GridLayout(lines.length, 1));
        this.setVisible(true);
        this.setTitle(file.getName());
        this.setBounds(3 * frameWidth, frameHeight, frameWidth, frameHeight);


        for (String line : lines) this.add(new JLabel(line));


    }


}
