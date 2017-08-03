package de.dhbwka.java.exercise.t3_operators;

//http://www.iai.kit.edu/~javavorlesung/dhbw/2015-16/05_Operatoren_Aufgaben.pdf

public class Easter {
	public String easter;

	public Easter(int year) {
		int a = year%19;
		int b = year%4;
		int c = year%7;
		int k = year/100;
		int p = (8*k + 13)/25;
		int q = k/4;
		int m = (15 + k - p - q)%30;
		int n = (4 + k - q)%7;
		int d = (19*a + m)%30;
		int e = (2*b + 4*c + 6*d + n)%7;
		int ostern = (22 + d + e);

		if (ostern >= 32) {
			this.easter = String.valueOf(ostern-31) + ". April";
		}
		else {
			this.easter=String.valueOf(ostern + ". März");
		}
	}
}
