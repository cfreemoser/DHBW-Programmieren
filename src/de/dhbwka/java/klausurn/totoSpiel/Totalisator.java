package de.dhbwka.java.klausurn.totoSpiel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cem on 13.10.16.
 */
public class Totalisator {
    final String name;

    final List<Paarung> paarungList = new ArrayList<>();
    final List<Tipper> tippList = new ArrayList<>();
    final List<Tipper> tippedUser = new ArrayList<>();
    final List<TipperTerminal> terminalList = new ArrayList<>();


    public Totalisator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Paarung> getPaarungen() {
        return paarungList;
    }

    public List<Tipper> getTippList() {
        return tippList;
    }

    public void addParrung(Paarung paarung) {
        this.paarungList.add(paarung);
    }

    public void addTipper(Tipper tipp) {
        this.tippList.add(tipp);

        TipperTerminal tipperTerminal = new TipperTerminal(tipp, tipp.getTotalisator());
    }

    public void removeTipper(Tipper tipp) {
        this.tippList.remove(tipp);
    }

    public void notifyCompleteTipp(Tipper tipper) {
        tippedUser.add(tipper);
        if (checkForCompletness())
            spielen();
    }

    private void spielen() {
        paarungList.forEach(Paarung::spielen);
        terminalList.forEach(TipperTerminal::spielBeendet);
    }

    private boolean checkForCompletness() {
        return tippedUser.size() == tippList.size();
    }

    public void addTerminal(TipperTerminal te) {
        terminalList.add(te);
    }
}
