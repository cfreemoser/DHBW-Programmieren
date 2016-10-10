package de.dhbwka.java.exercise.collections;

import java.util.*;

/**
 * Created by cem on 23.06.16.
 */
public class Lottery {

    public static void main(String[] args) {
        Random random = new Random();
        HashSet<Integer> mySet = new HashSet<>();

        while (mySet.size() != 7) mySet.add(random.nextInt(47));

        Iterator iterator = mySet.iterator();

        int superZahl = iterator.hasNext() ? (Integer) iterator.next() : 0;

        ArrayList<Integer> lottoZah = new ArrayList<>();

        while (iterator.hasNext()) lottoZah.add((Integer) iterator.next());
        Collections.sort(lottoZah);

        lottoZah.stream().map(lz -> lz + ",").forEach(System.out::print);
        System.out.print("Superzahl " + superZahl);
    }
}
