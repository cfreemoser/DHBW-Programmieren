package de.dhbwka.java.exercise.periodic;

import java.util.Arrays;

/**
 * Created by cem on 07.03.16.
 */
public class PeriodicTableTest {

    public static void main(String[] args) {
        PeriodicTable table = new PeriodicTable();
        Element wasserStoff = new Element("Wasserstroff", "H", 1, 'K', 3, true);
        Element helium = new Element("Helium", "He", 2, 'K', 3, true);
        Element brom = new Element("Brom", "Te", 52, 'O', 1, true);

        Element natrium = new Metal("Natrium", "Na", 11, 'M', 1, true, false, 21e6);
        Element eisen = new Metal("Eisen", "Fe", 26, 'M', 1, true, false, 10.02e6);
        Element tellur = new Metal("Tellur", "Te", 52, 'O', 1, true, true, 0.005);
        Element gold = new Metal("Gold", "Au", 79, 'P', 1, false, false, 44.0e6);
        Element germanium = new Metal("Germanium", "Ge", 32, 'N', 1, false, true, 1.45);


        table.addElement(wasserStoff);
        table.addElement(helium);
        table.addElement(brom);
        table.addElement(natrium);
        table.addElement(eisen);
        table.addElement(tellur);
        table.addElement(gold);
        table.addElement(germanium);

        System.out.println(Arrays.toString(table.elements));
        System.out.println("------------------------------");
        System.out.println(Arrays.toString(table.getMetals()));
    }
}
