package de.dhbwka.java.exercise.threads;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cem on 04.07.16.
 */
public class DancingFrame extends JFrame {

    public DancingFrame() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(400, 400));
        this.setLayout(new GridLayout(1, 1));
        this.add(new DancingComponents());
    }
}
