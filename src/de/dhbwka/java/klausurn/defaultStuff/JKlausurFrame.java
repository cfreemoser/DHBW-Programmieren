package de.dhbwka.java.klausurn.defaultStuff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by cem on 10.10.16.
 */
public abstract class JKlausurFrame extends JFrame implements ActionListener, Timer.TickAble {

    public JKlausurFrame(int width, int hight) {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Timer.getInstance().addTimer(this);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(width, hight));
        this.setSize(width, hight);
    }

    private void setLoggerPrefix(String prefix) {
        Logger.getInstance().setPrefix(prefix);
    }

    private void log(String msg) {
        Logger.getInstance().log(msg);
    }

    private void setLoggerFileName(String fileName) {
        Logger.getInstance().setFileName(fileName);
    }
}
