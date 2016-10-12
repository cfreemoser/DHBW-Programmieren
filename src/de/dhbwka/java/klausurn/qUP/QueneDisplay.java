package de.dhbwka.java.klausurn.qUP;

import de.dhbwka.java.klausurn.initStuff.JBaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

/**
 * Created by cem on 12.10.16.
 */
public class QueneDisplay extends JBaseFrame implements QueueObserver {
    final WaitingQuene quene;

    JLabel title = new JLabel("Keine Aufruf");
    JLabel waitingLabel = new JLabel("how many goes here");

    JTextArea listPanel = new JTextArea();
    Call myLastCall = null;

    public QueneDisplay(WaitingQuene waitingQuene) {
        super(400, 400);
        quene = waitingQuene;
        waitingQuene.addQueneObserver(this);
        de.dhbwka.java.klausurn.initStuff.Timer.getInstance().setInterval(5000);
        buildGUI();
    }

    private void buildGUI() {
        this.setLayout(new BorderLayout());
        //Header
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 24));
        waitingLabel.setFont(new Font(title.getFont().getName(), Font.BOLD, 12));
        JPanel header = new JPanel(new GridLayout(2, 1, 10, 10));
        header.add(title);
        header.add(waitingLabel);
        this.add(header, BorderLayout.NORTH);
        //Middle
        JScrollPane jScrollPane = new JScrollPane(listPanel);
        this.add(jScrollPane, BorderLayout.CENTER);
        //Button
        JButton button = new JButton("Nummer ziehen");
        button.addActionListener(this::nummerGezogen);
        this.add(button, BorderLayout.SOUTH);

        updateView();
    }

    private void nummerGezogen(ActionEvent actionEvent) {
        int number = quene.getNextQueneNumber();
        JOptionPane.showMessageDialog(this, String.valueOf(number), "Deine Nummer", 0);
    }

    @Override
    public void updateView() {
        waitingLabel.setText("Noch %data% Kunden im Wartebereich".replace("%data%", String.valueOf(quene.waitingClients())));
        listPanel.setText("");
        Call lastCall = quene.getLastCall();
        if (lastCall != null) setTitle(lastCall);

        for (Call call : quene.getCurrentCalls())
            listPanel.append(String.valueOf(call.getCustomerNumber()) +
                    " : " + call.getApp().getWorkStation() + " ("
                    + call.getApp().getRoom() + ")"
                    + System.lineSeparator());


    }

    private void setTitle(Call lastCall) {
        title.setText(String.valueOf(lastCall.getCustomerNumber()) +
                " : " + lastCall.getApp().getWorkStation() + " ("
                + lastCall.getApp().getRoom() + ")"
                + System.lineSeparator());
    }

    @Override
    public void tick() {
        if (quene != null) {
            if (quene.getCurrentCalls().size() > 1) {
                setTitle(quene.getCurrentCalls().get(new Random().nextInt(quene.getCurrentCalls().size() - 1)));
            }
        }
    }

}
