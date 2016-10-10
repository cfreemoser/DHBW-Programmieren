package de.dhbwka.java.exercise.threads.search;

/**
 * Created by cem on 07.07.16.
 */
public interface LoaderCallback {

    void onPageDownloaded(String html);

    void onPageSaved();

    void onFailed(Exception ex);
}
