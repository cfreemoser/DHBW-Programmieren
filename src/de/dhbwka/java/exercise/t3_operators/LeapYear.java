package de.dhbwka.java.exercise.t3_operators;

//http://www.iai.kit.edu/~javavorlesung/dhbw/2015-16/06_Kontrollstrukturen_Aufgaben.pdf

public class LeapYear {
	String leap;
	public LeapYear(int year){
		if (year%4==0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					this.leap = " (Leap-Year)";
				} else {
					this.leap = " (Not a Leap-Year)";
				}
			} else {
				this.leap = " (Leap-Year)";
			}
		}
			else {
				this.leap=" (Not a Leap-Year)";
			}
	}
}
