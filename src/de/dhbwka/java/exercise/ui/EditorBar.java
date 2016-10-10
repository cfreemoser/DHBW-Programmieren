package de.dhbwka.java.exercise.ui;

import javax.swing.*;

/**
 * Created by cem on 02.06.16.
 */
public class EditorBar extends JMenuBar {
    private final JMenu fileMenu = new JMenu("Datei");
    private final JMenu editMenu = new JMenu("Bearbeiten");

    public EditorBar() {
        initializeFileMenu();
        initializeBarMenu();
        this.add(fileMenu);
        this.add(editMenu);
    }

    private void initializeBarMenu() {
        MyMenu edit = new MyMenu(new String[]{"Rückgangig, Widerholen"});
        edit.appand(new MyMenu(new String[]{"Ausschneiden", "Kopieren", "Office-Zwischenablage", "Einfügen", "Inhalte Einfügen", "Als Hyperlink einfügen"}))
                .appand(new MyMenu(new String[]{"Löschen", "Alles markieren"}))
                .appand(new MyMenu(new String[]{"Suchen...", "Ersetzen...", "Gehen zu.."}))
                .appand(new MyMenu(new String[]{"Verknüpfung", "Objekt"}));

        edit.generate().forEach(editMenu::add);

    }


    private void initializeFileMenu() {

        MyMenu temp = new MyMenu(new String[]{"E-Mail-Empfänger", "E-Mail-Emofänger (zur Überarbeitung)", "E-Mail-Empfänger (als Anlage)"});
        temp.appand(new MyMenu(new String[]{"Verteilerempfänger..", "Onlinebsprechungsteilnehmer", "Exchange-Ordner...", "Fax-Empfänger"}))
                .appand(new MyMenu(new String[]{"Microsoft Powerpoint"}));
        MySubMenu emailMenu = new MySubMenu("Senden an", temp);


        MyMenu menu = new MyMenu(new String[]{"Neu", "Öffnen"});
        menu.appand(new MyMenu(new String[]{"Schließen"}))
                .appand(new MyMenu(new String[]{"Speichern", "Speichern unter...", "Als Website Speichern", "Suche"}))
                .appand(new MyMenu(new String[]{"Version"}))
                .appand(new MyMenu(new String[]{"Webseitenvorschau"}))
                .appand(new MyMenu(new String[]{"Seite einrichten...", "Seitenansicht", "Drucken"}))
                .appand(emailMenu)
                .appand(new MyMenu(new String[]{"bilanz_2007.doc", "quatalsbericht_2008_01.doc", "ziele.doc"}))
                .appand(new MyMenu(new String[]{"Beenden"}));


        menu.generate().forEach(fileMenu::add);
    }


}
