package de.dhbwka.java.exercise.classes;

/**
 * Created by cem on 08.02.16.
 */
public class RadioTest {

    public static void main(String[] args) {
        ///Radio
        Radio radio = new Radio();
        System.out.println(radio.toString());
        radio.decVolume();
        System.out.println(radio.toString());
        radio.setFrequency(102.69);
        System.out.println(radio.toString());
        radio.incVolume();
        System.out.println(radio.toString());

    }
}
