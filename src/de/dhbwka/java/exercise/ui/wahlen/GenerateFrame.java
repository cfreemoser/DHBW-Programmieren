package de.dhbwka.java.exercise.ui.wahlen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cem on 22.06.16.
 */
public class GenerateFrame extends JFrame implements ActionListener {
    private JButton addButton = new JButton("Hinzufügen");
    private JButton generateButton = new JButton("Grafik erstellen");

    public GenerateFrame() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(300, 500));
        this.setBounds(600, 600, 300, 500);
        configButtons();

        this.add(buildHead(), BorderLayout.PAGE_START);


    }

    public static void main(String[] args) {
        new GenerateFrame().setVisible(true);
    }

    private void configButtons() {
        generateButton.setFont(new Font("Courier New", Font.BOLD, 12));

    }

    private Component buildHead() {
        JPanel headPanel = new JPanel();
        headPanel.setLayout(new BorderLayout());
        headPanel.setSize(new Dimension(300, 200));
        headPanel.add(addButton, BorderLayout.WEST);
        headPanel.add(generateButton, BorderLayout.EAST);
        headPanel.setBackground(Utility.hex2Rgb("#3F51B5"));

        JLabel shadowLabel = new JLabel();
        shadowLabel.setSize(new Dimension(300, 3));
        shadowLabel.setBackground(Utility.hex2Rgb("#303F9F"));
        //  headPanel.add(shadowLabel, BorderLayout.PAGE_END);

        return headPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
