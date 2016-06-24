package de.dhbwka.java.exercise.ui;

import javax.swing.*;

/**
 * Created by cem on 16.06.16.
 */
public class BMICalculaterStarter {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        BMICalculator calculator = new BMICalculator();
        calculator.setVisible(true);
    }
}
