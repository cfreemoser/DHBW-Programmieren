package de.dhbwka.java.klausurn.qUP;

import de.dhbwka.java.klausurn.initStuff.JBaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by cem on 12.10.16.
 */
public class DeskApp extends JBaseFrame implements QueueObserver {
    final String workStation;
    final String room;
    final String worker;
    final WaitingQuene quene;

    JLabel watingLabel = new JLabel();
    JLabel currentLabel = new JLabel("---");
    JButton beginnButton = new JButton("Bearbeitung beginnen");
    JButton nextButton = new JButton("nächster Kunde");

    private Call currentCall = null;

    public DeskApp(WaitingQuene waitingQuene, String workStation, String room, String worker) {
        super(400, 400);
        this.workStation = workStation;
        this.room = room;
        this.worker = worker;
        waitingQuene.addQueneObserver(this);
        buildGUI();
        quene = waitingQuene;
    }

    private void buildGUI() {
        this.setTitle(workStation);
        this.setLayout(new BorderLayout());
        this.add(watingLabel, BorderLayout.NORTH);
        this.add(currentLabel, BorderLayout.CENTER);

        //Buttons
        JPanel bPanel = new JPanel(new GridLayout(1, 2));
        beginnButton.addActionListener(this::beginWork);
        beginnButton.setEnabled(false);
        nextButton.addActionListener(this::callNext);
        bPanel.add(beginnButton);
        bPanel.add(nextButton);
        this.add(bPanel, BorderLayout.SOUTH);

    }

    private void callNext(ActionEvent actionEvent) {
        if (quene.waitingClients() == 0) JOptionPane.showMessageDialog(this, "Keine wartende Kunden");
        else {
            currentCall = quene.getNextCall(this);
            currentLabel.setText("Aktuelle in Bearbeitung: Nummer " + currentCall.getCustomerNumber());
            beginnButton.setEnabled(true);
            nextButton.setEnabled(false);
        }
    }

    private void beginWork(ActionEvent actionEvent) {
        if (beginnButton.getText().equalsIgnoreCase("Bearbeitung beginnen")) {
            beginnButton.setText("Bearbeitung Abgeschlossen");
            quene.confirmCall(currentCall);
        } else {
            beginnButton.setText("Bearbeitung beginnen");
            beginnButton.setEnabled(false);
            nextButton.setEnabled(true);
        }
    }

    @Override
    public void updateView() {
        watingLabel.setText("Noch %data% Kunden im Wartebereich".replace("%data%", String.valueOf(quene.waitingClients())));


    }

    @Override
    public void tick() {

    }


    public String getWorkStation() {
        return workStation;
    }

    public String getRoom() {
        return room;
    }

    public String getWorker() {
        return worker;
    }

    public WaitingQuene getQuene() {
        return quene;
    }

    public JLabel getWatingLabel() {
        return watingLabel;
    }

    public JLabel getCurrentLabel() {
        return currentLabel;
    }

    public JButton getBeginnButton() {
        return beginnButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public Call getCurrentCall() {
        return currentCall;
    }
}
