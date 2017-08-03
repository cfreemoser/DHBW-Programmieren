package de.dhbwka.java.exercise.jbay;

public class Bieter {
	String firstName;
	String lastName;

	public Bieter(String first, String last) {
		this.firstName=first;
		this.lastName=last;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
}
