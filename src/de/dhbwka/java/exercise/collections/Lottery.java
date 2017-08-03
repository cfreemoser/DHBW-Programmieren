package de.dhbwka.java.exercise.collections;

import java.util.Set;
import java.util.TreeSet;
import java.util.Random;

public class Lottery {

	public static void main(String[] args) {
		Random rnd = new Random();
		int extra=0;
		Set lottery = new TreeSet();
		while (lottery.size()<7) {
			int number = rnd.nextInt(49)+1;
			lottery.add(number);
			if (lottery.size()==7){
				extra=number;
			}
		}
		lottery.remove(extra);

		for (Object o : lottery) {
			System.out.print(o + " ");
		}
		System.out.println("Zusatzzahl:" + extra);
	}
}
