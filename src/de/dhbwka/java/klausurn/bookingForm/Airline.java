package de.dhbwka.java.klausurn.bookingForm;

/**
 * Created by cem on 10.10.16.
 */
public class Airline {
    final String code;
    final String name;

    public Airline(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
