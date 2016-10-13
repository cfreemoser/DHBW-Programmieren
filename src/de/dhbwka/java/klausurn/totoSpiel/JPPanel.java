package de.dhbwka.java.klausurn.totoSpiel;

import de.dhbwka.java.exercise.utility.Tuple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by cem on 13.10.16.
 */
public class JPPanel extends JPanel {
    JPaar[] fields;

    public JPPanel(List<Paarung> paarungen) {
        this.setLayout(new GridLayout(paarungen.size(), 3, 10, 10));


        fields = new JPaar[paarungen.size()];
        for (int i = 0; i < fields.length; i++)
            fields[i] = new JPaar(paarungen.get(i));

        Arrays.stream(fields).forEach(this::add);
    }

    public Optional<List<Tuple<Paarung, Integer>>> getFields() {
        List<Tuple<Paarung, Integer>> integers = Arrays.stream(fields).map(JPaar::getInput)
                .filter(integer -> integer.y != null)
                .filter(integer -> integer.y <= 2 && integer.y >= 0)
                .collect(Collectors.toList());
        if (integers.size() == fields.length) {
            return Optional.of(integers);
        } else return Optional.empty();
    }

    public void updateView(List<Paarung> paarungen) {
        for (Paarung paarung : paarungen)
            for (JPaar panel : fields)
                panel.mayShowResult(paarung);
    }

    private int nextIndex(JTextField source) {
        int index = 0;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getField().equals(source) && i < fields.length - 1) {
                index = i + 1;
                break;
            } else index = 0;
        }
        return index;
    }

    class JPaar extends JPanel {
        final Paarung paarung;

        JTextField field = new JTextField();

        JPaar(Paarung paarung) {
            this.paarung = paarung;
            this.setLayout(new GridLayout(1, 1, 10, 10));
            this.add(new JLabel(paarung.toString()));
            this.add(field);
            field.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        fields[nextIndex(field)].getField().requestFocus();
                    }
                }
            });
        }


        public Tuple<Paarung, Integer> getInput() {
            try {
                Integer input = Integer.parseInt(field.getText());
                if (input > 2) {
                    field.requestFocus();
                    input = null;
                }
                return new Tuple<>(paarung, input);
            } catch (Exception e) {
                field.requestFocus();
                return new Tuple<>(paarung, null);
            }
        }


        public void mayShowResult(Paarung paarung) {
            if (this.paarung.equals(paarung)) {
                String current = field.getText();
                field.setText(current + " (" + paarung.spielStand() + ")");
            }
        }

        public Paarung getPaarung() {
            return paarung;
        }

        public JTextField getField() {
            return field;
        }
    }
}
