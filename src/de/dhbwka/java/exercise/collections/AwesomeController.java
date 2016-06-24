package de.dhbwka.java.exercise.collections;

/**
 * Created by cem on 23.06.16.
 */
public interface AwesomeController {
    Object getSortedBooksBy(LibSort sortBy);

    boolean addBooks(String title, String autor, String Verlag, int Jahr);

    void saveState();

    enum LibSort {
        AUTOR, TITLE, JAHR, VERLAG
    }

}
