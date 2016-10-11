package de.dhbwka.java.klausurn.jbay;

import de.dhbwka.java.klausurn.initStuff.SimpleLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * Created by cem on 09.10.16.
 */
public class MyJPanel extends JPanel implements ActionListener, SimpleLogger {
    final Auktion auktion;
    final Component parrent;
    Bieter bieter;

    //JLabels
    JLabel name = new JLabel();
    JLabel betrag = new JLabel();
    JLabel owner = new JLabel();
    JLabel endTime = new JLabel();

    //Button
    JButton button = new JButton("Gebot");

    public MyJPanel(Auktion auktion, Component parrent, Bieter bieter) {
        this.auktion = auktion;
        this.parrent = parrent;
        this.bieter = bieter;
        this.setLayout(new GridLayout(1, 5));
        this.add(name);
        this.add(betrag);
        this.add(owner);
        this.add(endTime);
        button.addActionListener(this);
        this.add(button);
        updateGUI();
    }

    public void updateGUI() {
        name.setText(auktion.getWare().getTitle());
        betrag.setText(String.valueOf(auktion.getPreis()));
        owner.setText(auktion.getGebot() != null ? auktion.gebot.getBieter().getFullName() : "---");
        endTime.setText(auktion.getEnde().getTime().toString());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (System.currentTimeMillis() > auktion.getEnde().getTimeInMillis()) {
            JOptionPane.showMessageDialog(parrent, "Die Auktion ist leider schon vorbei...");
        } else {
            double min = auktion.getPreis() + Auktion.INCREMENT;
            String result = JOptionPane.showInputDialog(parrent, "Bitte ein neues Gebot eingebenen" + System.lineSeparator() + "Mindestens " + min + " Euro", min);
            try {
                double sum = Double.parseDouble(result);
                log("(" + Calendar.getInstance().getTime().toString() + ") " + "Gebot von " + bieter.getFullName() + " für " + auktion.getWare().getTitle() + ": " + sum + " Euro");
                if (auktion.gebotAbgeben(new Gebot(bieter, sum))) {
                    JOptionPane.showMessageDialog(parrent, "Sie sind höchstbietender!");
                    TerminalHelper.getInstance().updateTerminals();
                } else {
                    JOptionPane.showMessageDialog(parrent, "Gebot zu Gering");
                }


            } catch (Exception e) {
                log(e.getMessage());
                JOptionPane.showMessageDialog(parrent, "Eingabe war Fehlerhaft!");
            }
        }
        {
        }

    }

    @Override
    public String setLogFileName() {
        return "jbay.txt";
    }
}
