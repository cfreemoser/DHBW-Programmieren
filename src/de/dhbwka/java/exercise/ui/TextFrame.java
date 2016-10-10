package de.dhbwka.java.exercise.ui;

import de.dhbwka.java.exercise.utility.UsefulStuff;

import javax.swing.*;
import java.io.File;

/**
 * Created by cem on 19.05.16.
 */
public class TextFrame extends JFrame {


    public TextFrame(int frameWidth, int frameHeight, File file) {
        this.setBounds(3 * frameWidth, frameHeight, frameWidth, frameHeight);
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        this.setVisible(true);
        this.add(scrollPane);
        this.setTitle(file.getName());

        textArea.append(UsefulStuff.readTextFromFile(file));
    }


}
