package de.dhbwka.java.klausurn.bookingForm;

/**
 * Created by cem on 10.10.16.
 */
public class Destination {
    final String name;
    final String ortsname;
    final String code;

    public Destination(String name, String ortsname, String code) {
        this.name = name;
        this.ortsname = ortsname;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getOrtsname() {
        return ortsname;
    }

    public String getCode() {
        return code;
    }
}
