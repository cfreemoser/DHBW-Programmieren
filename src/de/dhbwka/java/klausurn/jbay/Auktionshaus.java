package de.dhbwka.java.klausurn.jbay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cem on 09.10.16.
 */
public class Auktionshaus {

    List<Auktion> auktionen = new ArrayList<>();


    public void addAuktion(Auktion a) {
        auktionen.add(a);
    }

    public void removeAuktion(Auktion a) {
        auktionen.remove(a);
    }

    public List<Auktion> getAuktionen() {
        return auktionen;
    }
}
