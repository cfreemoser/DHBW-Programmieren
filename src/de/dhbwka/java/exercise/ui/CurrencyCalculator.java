package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cem on 21.06.16.
 */
public class CurrencyCalculator extends JFrame implements ActionListener {
    private final static String ACTION_EURO_TO_USD = "EURO_TO_USD";
    private final static String ACTION_USD_TO_EURO = "USD_TO_EURO";
    private final static String ACTION_CANCEL = "CANCEL";
    private final static String ACTION_ENTER = "ENTER";

    private JTextField inputField = new JTextField(30);
    private JButton euroTOUsdButton = new JButton("euro -> usd");
    private JButton usdTOEuroButton = new JButton("usd -> euro");
    private JButton cancelButton = new JButton("Abbrechen");

    public CurrencyCalculator() {
        this.setLayout(new GridLayout(2, 1));
        this.add(inputField);

        JPanel panel = new JPanel();
        panel.add(euroTOUsdButton);
        panel.add(usdTOEuroButton);
        panel.add(cancelButton);

        euroTOUsdButton.addActionListener(this);
        euroTOUsdButton.setActionCommand(ACTION_EURO_TO_USD);
        usdTOEuroButton.addActionListener(this);
        usdTOEuroButton.setActionCommand(ACTION_USD_TO_EURO);
        cancelButton.addActionListener(this);
        cancelButton.setActionCommand(ACTION_CANCEL);
        inputField.addActionListener(this);
        inputField.setActionCommand(ACTION_ENTER);

        this.add(panel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(3 * 300, 300, 400, 150);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case ACTION_USD_TO_EURO:
                calc(MyMode.USD);
                break;
            case ACTION_EURO_TO_USD:
                calc(MyMode.EURO);
                break;
            case ACTION_CANCEL:
                System.exit(0);
                break;
            case ACTION_ENTER:
                calc(MyMode.AUTO);
                break;
            default:
                showDialog("Oh something went wrong :(");
        }
    }

    private void calc(MyMode mode) {
        try {
            if (mode == MyMode.EURO)
                inputField.setText(String.valueOf(Double.parseDouble(inputField.getText()) * 1.14) + "$");
            else if (mode == MyMode.USD)
                inputField.setText(String.valueOf(Double.parseDouble(inputField.getText()) / 1.14) + "€");
            else if (inputField.getText().contains("€") || inputField.getText().contains("$")) {
                if (inputField.getText().contains("€")) {
                    inputField.setText(inputField.getText().replace("€", ""));
                    calc(MyMode.EURO);
                } else {
                    inputField.setText(inputField.getText().replace("$", ""));
                    calc(MyMode.USD);
                }
            }
        } catch (Exception ex) {

            showDialog("Oh something went wrong :( FUUUCK");
        }
    }

    private void showDialog(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Oh Jonney!", JOptionPane.ERROR_MESSAGE);
    }

    public enum MyMode {
        EURO, USD, AUTO
    }
}
