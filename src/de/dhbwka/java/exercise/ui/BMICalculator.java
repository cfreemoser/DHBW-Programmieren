package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cem on 16.06.16.
 */
public class BMICalculator extends JFrame implements ActionListener {

    private JButton calculateButton;
    private JTextField gewichtField = new JTextField(20);
    private JTextField großeField = new JTextField(20);
    private JTextField bmiField = new JTextField(20);
    private JTextField resultField = new JTextField(20);
    private JRadioButton maleRadioButton = new JRadioButton("männlich");
    private JRadioButton femaleRadioButton = new JRadioButton("weiblich");


    public BMICalculator() {
        this.setBounds(3 * 300, 300, 400, 400);
        this.setLayout(new GridLayout(6, 1));
        this.setResizable(false);

        JPanel gewichtPanel = new JPanel();
        gewichtPanel.add(new JLabel("Gewicht in KG"));
        gewichtPanel.add(gewichtField);

        JPanel groessePanel = new JPanel();
        groessePanel.add(new JLabel("Größe in m"));
        groessePanel.add(großeField);

        JPanel geschlechtsPanel = new JPanel();
        ButtonGroup group = new ButtonGroup();
        group.add(maleRadioButton);
        group.add(femaleRadioButton);

        geschlechtsPanel.add(maleRadioButton);
        geschlechtsPanel.add(femaleRadioButton);

        calculateButton = new JButton("Berechnen");
        calculateButton.addActionListener(this);

        this.add(gewichtPanel);
        this.add(groessePanel);
        this.add(geschlechtsPanel);
        this.add(calculateButton);


        JPanel bmiPanel = new JPanel();
        bmiPanel.add(new JLabel("BMI"));
        bmiPanel.add(bmiField);


        this.add(bmiPanel);
        this.add(resultField);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            int gewicht = 0;
            double groesse = 0;
            boolean female = false;
            try {
                gewicht = Integer.parseInt(gewichtField.getText().replace("kg", ""));
            } catch (Exception pe) {
                showError("Gewichts angabe ist falsch!");
            }

            try {
                groesse = Double.parseDouble(großeField.getText().replace(",", "."));
            } catch (Exception pe) {
                showError("Größe angabe ist falsch!");
            }

            if (!maleRadioButton.isSelected() && !femaleRadioButton.isSelected())
                showError("Bitte ein Geschlecht wählen!");
            else female = femaleRadioButton.isSelected();

            if (gewicht <= 0) showError("Du kannst nicht weniger als 0kg wiegen!");
            if (groesse <= 0) showError("Du bist aber echt klein :(");

            double bmi = gewicht / Math.pow(groesse, 2);
            bmiField.setText(String.valueOf(bmi));

            resultField.setText(resultBasedText(female, bmi));


        }
    }

    private String resultBasedText(boolean female, double bmi) {
        if (female)
            return femaleText(bmi);
        else return maleText(bmi);
    }

    private String femaleText(double bmi) {
        if (bmi < 19) return "Untergewicht";
        else if (bmi < 24) return "Normalgewicht";
        else return genderText(bmi);
    }

    private String maleText(double bmi) {

        if (bmi < 20) return "Untergewicht";
        else if (bmi < 25) return "Normalgewicht";
        else return genderText(bmi);

    }

    private String genderText(double bmi) {
        if (bmi < 30) return "Übergewicht";
        else if (bmi < 40) return "Adipositas";
        else return "massive Adipositas";
    }

    private void showError(String s) {
        JOptionPane.showMessageDialog(this, s, "Oh Jonney!", JOptionPane.ERROR_MESSAGE);
    }
}
