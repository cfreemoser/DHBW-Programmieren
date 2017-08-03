package de.dhbwka.java.exercise.jbay;

import java.util.Calendar;

public class Auktion {
	static double INCREMENT=1.0;
	Ware ware;
	Gebot bet = null;
	double price = 0.0;
	Calendar ending;

	boolean gebotAbgeben(Gebot g) {
		if (this.bet==null) {
			this.price=INCREMENT;
			this.bet=g;
			return true;
		}
		if (g.better==this.bet.better) {
			if (g.bet>this.bet.bet) {
				this.bet=g;
				return true;
			}
		}
		if (g.bet>=(this.price+INCREMENT)) {
			if (g.bet<=this.bet.bet) {
				this.price=this.minimum(g.bet+INCREMENT, this.bet.bet);
			}
			else {
				this.price=this.minimum(g.bet, this.bet.bet+INCREMENT);
				this.bet = g;
				return true;
			}
		}
		return false;
	}

	private double minimum (double a, double b) {
		if (a<b) {
			return a;
		}
		return b;
	}

	public Auktion (Ware ware, int dauer) {
		this.ware=ware;
		ending=Calendar.getInstance();
		ending.setTimeInMillis(System.currentTimeMillis()+60000*dauer);
	}
}

