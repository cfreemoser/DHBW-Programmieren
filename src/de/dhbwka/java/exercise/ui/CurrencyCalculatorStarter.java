package de.dhbwka.java.exercise.ui;

import javax.swing.*;

/**
 * Created by cem on 21.06.16.
 */
public class CurrencyCalculatorStarter {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        CurrencyCalculator currencyCalculator = new CurrencyCalculator();

        currencyCalculator.setVisible(true);
    }
}
