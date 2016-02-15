package de.dhbwka.java.exercise.classes;

/**
 * Created by cem on 14.02.16.
 */
public class DeutschesLotto {

    public static void main(String[] args) {
        Lotto deutschesLotto = new Lotto(6, 49);
        deutschesLotto.tippen();
        System.out.println(deutschesLotto.toString());
        deutschesLotto.ziehen();
        System.out.println(deutschesLotto.toString() + "\n");

        main(null);
    }
}
