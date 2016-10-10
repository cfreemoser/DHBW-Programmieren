package de.dhbwka.java.exercise.ui;

import de.dhbwka.java.exercise.utility.MyFileFilter;

import javax.swing.*;
import java.awt.event.ActionListener;


public class MyFileChooser extends JFileChooser {

    public MyFileChooser(ActionListener listener) {
        makeChooser();
        this.addActionListener(listener);
    }

    public MyFileChooser() {
        makeChooser();
    }

    private void makeChooser() {
        this.setApproveButtonText("Open");
        this.setDialogTitle("Pick a file");
        this.setFileFilter(MyFileFilter.getInstance());
    }
}
