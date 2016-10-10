package de.dhbwka.java.klausurn.jbay;

import de.dhbwka.java.klausurn.defaultStuff.JKlausurFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.stream.Collectors;

/**
 * Created by cem on 09.10.16.
 */
public class BieterTerminal extends JKlausurFrame {
    final Bieter bieter;
    final Auktionshaus ah;
    final Component parrent = this;
    java.util.List<MyJPanel> myPnaels;


    //UI
    JLabel timeLabel = new JLabel(Calendar.getInstance().getTime().toString());

    public BieterTerminal(Bieter bieter, Auktionshaus ah) {
        super(600, 300);
        this.bieter = bieter;
        this.ah = ah;
        buildGUI();
        TerminalHelper.getInstance().regester(this);
    }

    private void buildGUI() {
        this.setTitle(bieter.getFullName());
        this.setLayout(new BorderLayout());
        this.add(timeLabel, BorderLayout.NORTH);
        this.add(buildAuktionenPanel());

    }

    private JPanel buildAuktionenPanel() {
        JPanel panel = new JPanel();
        myPnaels = ah.getAuktionen().stream().map(auktion -> {
            return new MyJPanel(auktion, parrent, bieter);
        }).collect(Collectors.toList());
        panel.setLayout(new GridLayout(myPnaels.size(), 1));
        for (MyJPanel somePanel : myPnaels) panel.add(somePanel);
        return panel;
    }

    public void updateInformation() {
        myPnaels.forEach(MyJPanel::updateGUI);
    }

    @Override
    public void tick() {
        timeLabel.setText(Calendar.getInstance().getTime().toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
