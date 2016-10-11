package de.dhbwka.java.klausurn.bookingForm;

import de.dhbwka.java.klausurn.initStuff.JBaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by cem on 10.10.16.
 */
public class BookingForm extends JBaseFrame {
    //Data
    final Flug flug;
    //Helper
    String[] abc = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "v", "W", "X", "Y", "Z"};
    java.util.List<UpdateAble> updateAbles = new ArrayList<>();
    //Panels
    JPanel headerPanel = new JPanel();
    JPanel sitzePanel = new JPanel();
    JPanel buttomPanel = new JPanel();

    //
    JLabel timeLabel = new JLabel();
    JLabel freiePlaetzeLabel = new JLabel();

    public BookingForm(Flug flug) {
        super(800, 800);
        this.flug = flug;
        createGUI();
    }

    private void createGUI() {
        //header
        headerPanel.setLayout(new GridLayout(5, 5));
        headerPanel.add(new JLabel("Fluggesellschaft"));
        headerPanel.add(new JLabel(flug.getAirline().getName()));
        headerPanel.add(new JLabel("von:"));
        headerPanel.add(new JLabel(flug.getFrom().getName() + " (" + flug.getFrom().getCode() + ")"));
        headerPanel.add(new JLabel("nach:"));
        headerPanel.add(new JLabel(flug.getTo().getName() + " (" + flug.getTo().getCode() + ")"));
        headerPanel.add(new JLabel("freie Plätze:"));
        headerPanel.add(freiePlaetzeLabel);
        headerPanel.add(new JLabel("Zeit:"));
        headerPanel.add(timeLabel);
        updateHeaderPanel();

        //sitze
        int reihen = flug.getSitzs().length;
        int sitzeProReihe = flug.getSitzs()[0].length;
        sitzePanel.setLayout(new GridLayout(reihen, sitzeProReihe, 10, 10));

        for (Sitz[] reihe : flug.getSitzs()) {
            for (Sitz oneSitz : reihe) {
                String name = (oneSitz.getReihe() + 1) + abc[oneSitz.getPostion()];
                SitzButton button = new SitzButton(oneSitz, name);
                sitzePanel.add(button);
                updateAbles.add(button);
            }
        }


        //Button
        buttomPanel.setLayout(new GridLayout(1, 2));
        JButton buchenButton = new JButton("Buchen");
        buchenButton.addActionListener(this::bookButtonClicked);
        buttomPanel.add(buchenButton);

        JButton discardButton = new JButton("Verwerfen");
        discardButton.addActionListener(this::discardButtonClicked);
        buttomPanel.add(discardButton);

        this.setLayout(new BorderLayout());
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(sitzePanel, BorderLayout.CENTER);
        this.add(buttomPanel, BorderLayout.SOUTH);


    }

    private void discardButtonClicked(ActionEvent actionEvent) {
        updateAbles.forEach(buttonInterface -> buttonInterface.update(false));
    }

    private void bookButtonClicked(ActionEvent actionEvent) {
        updateAbles.forEach(buttonInterface -> buttonInterface.update(true));

    }

    private void updateHeaderPanel() {
        timeLabel.setText(Calendar.getInstance().getTime().toString());
        freiePlaetzeLabel.setText(String.valueOf(flug.freiePlaetze()));
    }



    @Override
    public void tick() {
        updateHeaderPanel();
    }


    @Override
    public String setLogFileName() {
        return "";
    }
}
