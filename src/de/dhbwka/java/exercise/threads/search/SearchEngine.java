package de.dhbwka.java.exercise.threads.search;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cem on 07.07.16.
 */
public class SearchEngine implements LoaderCallback {
    private final String[] urls;
    private final int maxThreads;
    private final ExecutorService downloadService;
    private final ExecutorService ioService;

    public SearchEngine(String[] urls, int maxThreads) {
        this.urls = urls;
        this.maxThreads = maxThreads;
        this.downloadService = Executors.newFixedThreadPool(maxThreads / 2);
        this.ioService = Executors.newFixedThreadPool(maxThreads / 2);
        PageLoader loader = new PageLoader(urls[0], this);
        loader.run();
    }

    public static void main(String[] args) {
        SearchEngine engine = new SearchEngine(new String[]{"https://www.google.de"}, 1);
    }

    private void startThreads() {
        for (String url : urls)
            downloadService.execute(new PageLoader(url, this));
    }

    @Override
    public void onPageDownloaded(String html) {
        ioService.execute(new AsynchronousFileWriter(html, this));
    }

    @Override
    public void onPageSaved() {
    }

    @Override
    public void onFailed(Exception ex) {

    }
}
