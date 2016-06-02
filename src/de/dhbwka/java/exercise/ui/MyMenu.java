package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by cem on 02.06.16.
 */
public class MyMenu {

    String[] menuItems = null;
    MySubMenu subItem = null;
    MyMenu followingItem = null;

    public MyMenu(String[] menuItems, MySubMenu subItems, MyMenu followingItem) {
        this.menuItems = menuItems;
        this.subItem = subItems;
        this.followingItem = followingItem;
    }

    public MyMenu(String[] menuItems, MySubMenu subItems) {
        this.menuItems = menuItems;
        this.subItem = subItems;
    }

    public MyMenu(String[] menuItems) {
        this.menuItems = menuItems;
    }


    public MyMenu appand(MyMenu appendItem) {
        this.followingItem = appendItem;
        return appendItem;
    }

    public MyMenu appand(MySubMenu subItem) {
        this.subItem = subItem;
        return this;
    }

    public ArrayList<Component> generate() {
        if (menuItems == null) return null;

        ArrayList<Component> items = new ArrayList<>();

        for (String name : menuItems) items.add(new JMenuItem(name));

        if (subItem != null) items.add(subItem.generate());

        if (followingItem != null) {
            items.add(new JPopupMenu.Separator());
            items.addAll(followingItem.generate());
        }


        return items;

    }


}
