package de.dhbwka.java.klausurn.jbay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cem on 09.10.16.
 */
public class TerminalHelper {
    private static TerminalHelper ourInstance = new TerminalHelper();
    private List<BieterTerminal> terminals = new ArrayList<>();

    private TerminalHelper() {
    }

    public static TerminalHelper getInstance() {
        return ourInstance;
    }

    public void regester(BieterTerminal terminal) {
        terminals.add(terminal);
    }

    public void updateTerminals() {
        terminals.forEach(BieterTerminal::updateInformation);
    }
}
