package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class ComponentFrame {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JFrame frame = new JFrame("Uebung 1");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel firstLine = new JPanel();
        JPanel secondLine = new JPanel();
        ButtonGroup group = new ButtonGroup();

        firstLine.add(new JLabel("Label"));
        firstLine.add(new JPasswordField("total geheim"));
        firstLine.add(new JButton("Button"));
        firstLine.add(new JToggleButton("ToggleMe"));
        firstLine.add(new JCheckBox("JCheckBox"));
        firstLine.add(makeJCombo());

        for (int i = 0; i < 3; i++) {
            JRadioButton rButton = new JRadioButton("Radio " + (i + 1));
            group.add(rButton);
            secondLine.add(rButton);
        }

        frame.add(firstLine);
        frame.add(secondLine);


        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(500, 110);
        frame.setVisible(true);

    }

    private static Component makeJCombo() {
        JComboBox<String> jcombo = new JComboBox<String>();
        jcombo.addItem("henne");
        jcombo.addItem("ist");
        jcombo.addItem("doof");
        return jcombo;
    }
}
