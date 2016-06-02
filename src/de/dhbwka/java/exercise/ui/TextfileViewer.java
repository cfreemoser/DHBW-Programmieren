package de.dhbwka.java.exercise.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextfileViewer implements ActionListener {
    private final MyFileChooser chooser = new MyFileChooser(this);

    public TextfileViewer() {
        chooser.showDialog(null, "Pick a File");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getModifiers()) {
            case MyFileChooser.APPROVE_OPTION:
                openFile();
                break;
            default:
                System.out.println(e.getID());
        }

    }

    private void openFile() {
        new TextFrameStatic(600, 600, chooser.getSelectedFile());
        new TextFrame(300, 300, chooser.getSelectedFile());
    }
}