package de.dhbwka.java.exercise.threads.search.Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by cem on 07.07.16.
 */
public class WelcomeFrame extends JFrame {
    private BackgroundPanel backgroundPanel;

    public WelcomeFrame() {
        this.setLayout(new GridLayout(1, 1));
        addElements();
        buildGUI();

    }

    public static void main(String[] args) {
        WelcomeFrame welcomeFrame = new WelcomeFrame();
    }

    public void addElements() {
        backgroundPanel = new BackgroundPanel(new ImageIcon("src/de/dhbwka/resources/welcome.gif").getImage(), BackgroundPanel.ACTUAL);
        backgroundPanel.setLayout(new BorderLayout(0, 0));

        JPanel settingPanel = new JPanel();
        JButton button = new JButton();
        button.setIcon(new ImageIcon("src/de/dhbwka/resources/add.png"));
        button.setBackground(null);
        button.addActionListener(this::addField);
        button.setForeground(null);
        backgroundPanel.add(button, BorderLayout.EAST);

        this.add(backgroundPanel, BorderLayout.CENTER);

    }

    private void addField(ActionEvent actionEvent) {
        backgroundPanel.add(new JTextField(), BorderLayout.CENTER);
    }

    private void buildGUI() {
        this.setPreferredSize(new Dimension(1200, 1200));
//        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }


}
