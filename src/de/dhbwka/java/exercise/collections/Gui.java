package de.dhbwka.java.exercise.collections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by cem on 23.06.16.
 */
public class Gui extends JFrame implements WindowListener {
    private static final String ACTION_SAVE = "ACTION_SAVE";
    private final AwesomeController controller;
    JTextField[] fields = new JTextField[4];


    public Gui(AwesomeController controller) {
        this.controller = controller;
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setSize(400, 400);
        this.addWindowListener(this);
        buildUI();

    }

    private void buildUI() {
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(4, 2, 2, 2));
        String[] names = {"Title", "Autor", "Verlag", "Jahr"};
        for (int i = 0; i < fields.length; i++) {
            fields[i] = new JTextField();
            fields[i].setSize(200, 60);
            top.add(new JLabel(names[i]));
            top.add(fields[i]);
        }
        this.add(top);


        JButton saveButton = new JButton("Eintrag Speichern");
        saveButton.setActionCommand(ACTION_SAVE);
        saveButton.addActionListener(this::onButtonClicked);
        this.add(saveButton, BorderLayout.PAGE_END);

        JPanel button = new JPanel();
        button.setLayout(new GridLayout(1, 5));
        button.add(new JLabel("Sortieren nach:"));
        for (String name : names) {
            JButton temp = new JButton(name);
            temp.setActionCommand(name);
            temp.addActionListener(this::bottomAction);
            button.add(temp);
        }
        this.add(button);


    }

    private void bottomAction(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "Title":
                showDialog("Sortiert nach Title", (String) controller.getSortedBooksBy(AwesomeController.LibSort.TITLE));
                break;
            case "Autor":
                showDialog("Sortiert nach Autor", (String) controller.getSortedBooksBy(AwesomeController.LibSort.AUTOR));
                break;
            case "Verlag":
                showDialog("Sortiert nach Verlag", (String) controller.getSortedBooksBy(AwesomeController.LibSort.VERLAG));
                break;
            case "Jahr":
                showDialog("Sortiert nach Jahr", (String) controller.getSortedBooksBy(AwesomeController.LibSort.JAHR));
                break;
        }
    }

    private void onButtonClicked(ActionEvent actionEvent) {

        if (verifyInput())
            if (!controller.addBooks(fields[0].getText(), fields[1].getText(), fields[2].getText(), Integer.parseInt(fields[3].getText())))
                showDialog("Konnte nicht hinzugefügt werden");
            else clearFields();

        else showDialog("Something went wrong");


    }

    private void clearFields() {
        for (JTextField field : fields)
            field.setText("");
    }


    private void showDialog(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Oh Jonney", JOptionPane.PLAIN_MESSAGE);
    }

    private void showDialog(String title, String msg) {
        JOptionPane.showMessageDialog(this, msg, title, JOptionPane.PLAIN_MESSAGE);
    }

    private boolean verifyInput() {
        for (JTextField field : fields)
            if (field.getText().length() <= 0) return false;
        return fields[3].getText().matches("[0-9]+");
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("hallo");
        this.setVisible(false);
        controller.saveState();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
