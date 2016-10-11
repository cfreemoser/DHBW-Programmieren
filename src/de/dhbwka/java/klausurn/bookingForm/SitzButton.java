package de.dhbwka.java.klausurn.bookingForm;

import de.dhbwka.java.klausurn.initStuff.SimpleLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cem on 10.10.16.
 */
public class SitzButton extends JButton implements ActionListener, UpdateAble, SimpleLogger {
    final static String ACTION = "SOME_ACTION";
    final Sitz sitz;

    public SitzButton(Sitz sitz, String name) {
        this.sitz = sitz;
        this.setText(name);
        this.addActionListener(this);
        this.setBackground(Color.white);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (sitz.buchungsstatus == Buchungsstatus.PENDING) {
            this.setBackground(Color.white);
            sitz.setBuchungsstatus(Buchungsstatus.FREI);
        } else if (sitz.buchungsstatus == Buchungsstatus.FREI) {
            this.setBackground(Color.red);
            sitz.setBuchungsstatus(Buchungsstatus.PENDING);
        }
    }

    @Override
    public void update(boolean buchen) {
        if (buchen && sitz.buchungsstatus == Buchungsstatus.PENDING) {
            this.setEnabled(false);
            this.setBackground(Color.white);
            sitz.setBuchungsstatus(Buchungsstatus.GEBUCHT);
            log("Gebucht: " + this.getText(), DatumPlace.RIGHT);
        } else if (sitz.buchungsstatus == Buchungsstatus.PENDING) {
            this.setBackground(Color.white);
            sitz.setBuchungsstatus(Buchungsstatus.FREI);
        }
    }

    @Override
    public String setLogFileName() {
        return "booking.txt";
    }
}
