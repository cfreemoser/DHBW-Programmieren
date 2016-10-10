package de.dhbwka.java.klausurn.bookingForm;

public class Main {

    public static void main(String[] args) {
        Destination frankfurt = new Destination("Flughafen Berlin Brandenburg", "Frankfurt am Main", "FRA");
        Destination newyork = new Destination("Int. Flughafen 'John F. Kennnedy'", "New York City", "JFK");
        Airline lufthanse = new Airline("DLH", "Deutsche Lufthansa");
        Flug f = new Flug("LH4711", lufthanse, frankfurt, newyork, 15, 4);
        BookingForm bookingForm = new BookingForm(f);

    }
}
