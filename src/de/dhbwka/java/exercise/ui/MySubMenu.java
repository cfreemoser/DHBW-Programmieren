package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cem on 02.06.16.
 */
public class MySubMenu {
    String title;
    MyMenu menu;

    public MySubMenu(String title, MyMenu menu) {
        this.title = title;
        this.menu = menu;
    }

    public Component generate() {
        JMenu jmenu = new JMenu(title);
        menu.generate().forEach(jmenu::add);
        return jmenu;
    }


}
