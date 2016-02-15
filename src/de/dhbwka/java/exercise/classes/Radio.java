package de.dhbwka.java.exercise.classes;

/**
 * Created by cem on 08.02.16.
 */
public class Radio {
    private boolean on;
    private int volume;
    private double frequency;

    public Radio() {
        this.on = true;
        this.frequency = 99.0;
        this.volume = 5;

    }

    public Radio(boolean on, int volume, double frequency) {
        this.on = on;
        if (volume > 0 && volume < 10) this.volume = volume;
        setFrequency(frequency);
    }


    public void setFrequency(double frequency) {
        if (frequency > 85.0 && frequency < 110.0)
            this.frequency = frequency;
        else this.frequency = 99.0;


    }

    public void decVolume() {
        if (on && volume > 0) volume--;
    }

    public void incVolume() {
        if (on && volume < 10) volume++;
    }

    public void turnOff() {
        on = false;
    }

    public void turnOn() {
        on = true;
    }


    @Override
    public String toString() {
        String radioOn = "";
        if (on) radioOn = "Radio ist an;";
        else radioOn = "Radio ist aus;";
        return radioOn + " Lautstärke " + volume + "; Frequenze " + frequency;
    }
}
