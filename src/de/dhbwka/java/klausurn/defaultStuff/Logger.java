package de.dhbwka.java.klausurn.defaultStuff;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by cem on 10.10.16.
 */
public class Logger {

    private static Logger ourInstance = new Logger();
    private String fileName = "log.txt";
    private String preFix = "";

    private Logger() {
    }

    public static Logger getInstance() {
        return ourInstance;
    }

    public void log(String msg) {
        try (PrintStream ps = new PrintStream(new FileOutputStream(new File(fileName), true))) {
            ps.println(preFix + msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPreFix() {
        return preFix;
    }

    public void setPrefix(String preFix) {
        this.preFix = preFix;
    }
}
