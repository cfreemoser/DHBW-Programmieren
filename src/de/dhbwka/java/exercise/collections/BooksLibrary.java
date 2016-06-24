package de.dhbwka.java.exercise.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by cem on 23.06.16.
 */
public class BooksLibrary implements Library<Books> {

    private HashSet<Books> booksHashSet = new HashSet<>();

    public boolean contains(Books item) {
        return false;
    }

    @Override
    public boolean add(Books item) {
        return booksHashSet.add(item);
    }

    @Override
    public boolean remove(Books item) {
        return false;
    }

    @Override
    public <U extends Comparable<? super U>> Stream<Books> sortBy(Function<Books, ? extends U> keyExtractor) {
        return booksHashSet.stream().sorted(Comparator.comparing(keyExtractor));
    }

    public HashSet<Books> getAll() {
        return booksHashSet;
    }


}
