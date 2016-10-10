package de.dhbwka.java.exercise.methods;

/**
 * Created by cem on 29.02.16.
 */
public class Quicksort {

    public int[] daten;

    public Quicksort(int[] daten) {
        this.daten = daten;
    }


    public void quicksort(int links, int rechts) {
        if (links < rechts) {
            int teiler = teile(links, rechts);
            quicksort(links, teiler - 1);
            quicksort(teiler + 1, rechts);
        }
    }

    private int teile(int links, int rechts) {
        int i = links;
        int j = rechts - 1;
        int pivot = daten[rechts];

        while (true) {
            while (daten[i] <= pivot && i < rechts)
                i = i + 1;
            while (daten[j] >= pivot && j > links)
                j = j - 1;
            if (i < j) {
                int temp = daten[i];
                daten[i] = daten[j];
                daten[j] = temp;
            }
            while (i < j) {
                if (daten[i] > pivot) {
                    int temp = daten[i];
                    daten[i] = daten[rechts];
                    daten[rechts] = temp;
                }
            }
            return i;
        }
    }
}
