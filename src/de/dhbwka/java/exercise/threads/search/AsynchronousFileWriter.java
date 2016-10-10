package de.dhbwka.java.exercise.threads.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by cem on 07.07.16.
 */
public class AsynchronousFileWriter implements Runnable {

    private final String html;
    private final LoaderCallback callback;

    public AsynchronousFileWriter(String html, LoaderCallback callback) {
        this.html = html;
        this.callback = callback;
    }

    @Override
    public void run() {
        File folder = new File("Downloads");
        folder.mkdir();
        try (PrintWriter writer = new PrintWriter(new File(folder.getAbsoluteFile(), String.valueOf(System.currentTimeMillis())))) {
            Arrays.asList(html.split(System.lineSeparator())).forEach(writer::println);
            callback.onPageSaved();
        } catch (FileNotFoundException e) {
            callback.onFailed(e);
        }


    }
}
