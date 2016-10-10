package de.dhbwka.java.exercise.periodic;

import java.util.Arrays;

/**
 * Created by cem on 07.03.16.
 */
public class PeriodicTable {

    public Element[] elements = new Element[118];

    public void addElement(Element element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                if (elements[i].equals(element)) return;
            } else {
                elements[i] = element;
                return;
            }


        }
    }

    public Element getElement(int ordinal) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && elements[i].ordinal == ordinal)
                return elements[i];
        }
        return null;
    }

    public Object[] getMetals() {
        return Arrays.stream(elements).filter(a -> a instanceof Metal).map(a -> (Metal) a).filter(a -> !a.isMetalloid()).toArray();
    }


}
