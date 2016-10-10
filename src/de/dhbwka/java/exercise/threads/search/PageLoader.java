package de.dhbwka.java.exercise.threads.search;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by cem on 07.07.16.
 */
public class PageLoader implements Runnable {
    private final String url;
    private final LoaderCallback callback;

    public PageLoader(String url, LoaderCallback callback) {
        this.url = url;
        this.callback = callback;
    }


    @Override
    public void run() {
        callback.onPageDownloaded(getPageContent());
    }

    private String getPageContent() {
        StringBuilder buffer = new StringBuilder("");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(new URL(url).openConnection().getInputStream())))) {
            while (reader.ready()) buffer.append(reader.readLine()).append(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }
}
