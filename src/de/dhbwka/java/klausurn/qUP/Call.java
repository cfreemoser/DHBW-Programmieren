package de.dhbwka.java.klausurn.qUP;

/**
 * Created by cem on 12.10.16.
 */
public class Call {
    private final int customerNumber;
    private final DeskApp app;

    public Call(int customerNumber, DeskApp app) {
        this.customerNumber = customerNumber;
        this.app = app;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public DeskApp getApp() {
        return app;
    }
}
