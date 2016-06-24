package de.dhbwka.java.exercise.collections;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by cem on 23.06.16.
 */
public interface Library<T> {

    boolean contains(T item);

    boolean add(T item);

    boolean remove(T item);

//    public T[] sortBy(Function function);

    <U extends Comparable<? super U>> Stream<T> sortBy(Function<T, ? extends U> keyExtractor);

}
