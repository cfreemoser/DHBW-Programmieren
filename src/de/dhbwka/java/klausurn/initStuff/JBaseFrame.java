package de.dhbwka.java.klausurn.initStuff;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cfreemoser on 10.10.16.
 */
public abstract class JBaseFrame extends JFrame implements Timer.TickAble {

    public JBaseFrame(int width, int height) {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(width, height));
        this.setSize(width, height);

        //someButton.addActionListener(this::someButtonClicked);

        Timer.getInstance().addTimer(this);
    }

//    private void someButtonButtonClicked(ActionEvent actionEvent) {
//
//    }
}
