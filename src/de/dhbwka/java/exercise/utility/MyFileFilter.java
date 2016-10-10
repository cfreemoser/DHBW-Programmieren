package de.dhbwka.java.exercise.utility;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by cem on 02.06.16.
 */
public class MyFileFilter extends FileFilter {

    private static MyFileFilter instance = null;

    private MyFileFilter() {
    }

    public static MyFileFilter getInstance() {
        if (instance == null) instance = new MyFileFilter();
        return instance;
    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) return true;
        else return f.getAbsoluteFile().toString().endsWith(".txt");

    }

    @Override
    public String getDescription() {
        return "Only .txt";
    }
}
