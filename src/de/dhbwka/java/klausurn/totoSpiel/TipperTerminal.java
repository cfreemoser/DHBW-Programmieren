package de.dhbwka.java.klausurn.totoSpiel;

import de.dhbwka.java.exercise.utility.Tuple;
import de.dhbwka.java.klausurn.initStuff.JBaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Optional;

/**
 * Created by cem on 13.10.16.
 */
public class TipperTerminal extends JBaseFrame {
    final Tipper tipper;
    final Totalisator totalisator;

    //UI
    JLabel titleLabel = new JLabel();
    JButton tippButton = new JButton("Tipp Abschließen");
    JPPanel paarungenPanel;


    public TipperTerminal(Tipper tipper, Totalisator totalisator) {
        super(400, 400);
        this.tipper = tipper;
        this.totalisator = totalisator;
        this.setTitle(tipper.getVorname() + " " + tipper.getNachname());
        totalisator.addTerminal(this);
        buildGUI();
    }

    private void buildGUI() {
        this.setLayout(new BorderLayout());
        this.add(titleLabel, BorderLayout.NORTH);
        this.add(tippButton, BorderLayout.SOUTH);

        paarungenPanel = new JPPanel(totalisator.getPaarungen());
        this.add(paarungenPanel, BorderLayout.CENTER);
        this.tippButton.addActionListener(this::abschliessen);
        this.repaint();
    }

    private void abschliessen(ActionEvent actionEvent) {
        Optional<List<Tuple<Paarung, Integer>>> schaetzungen = paarungenPanel.getFields();
        if (!schaetzungen.isPresent()) JOptionPane.showMessageDialog(this, "Eingabe Überprüfen");
        else {
            tippButton.setEnabled(false);
            schaetzungen.get().stream()
                    .map(paarungIntegerTuple -> new Tipp(paarungIntegerTuple.x, paarungIntegerTuple.y))
                    .forEach(tipper::addTipp);
            totalisator.notifyCompleteTipp(tipper);
            JOptionPane.showMessageDialog(this, "Eingabe Korrekt warte auf das Ergebnis");
        }
    }

    public void spielBeendet() {
        List<Paarung> paarungen = totalisator.getPaarungen();
        paarungenPanel.updateView(paarungen);

        int sumCorrect = 0;
        for (Tipp tipp : tipper.getTipps()) {
            if (tipp.getPaarung().getToreGast() == tipp.getPaarung().getToreHeim() && tipp.tipp == 0) sumCorrect++;
            else if (tipp.getPaarung().getToreGast() > tipp.getPaarung().getToreHeim() && tipp.tipp == 2) sumCorrect++;
            else if (tipp.getPaarung().getToreGast() < tipp.getPaarung().getToreHeim() && tipp.tipp == 1) sumCorrect++;
        }


        JDialog dialog = new JDialog(this, false);
        dialog.add(new JLabel(sumCorrect + " richtig getippt"));
        dialog.setTitle("Ergebnis von " + tipper.getVorname() + " " + tipper.getNachname());
        dialog.setSize(200, 200);
        dialog.setVisible(true);
    }

    @Override
    public void tick() {

    }
}
