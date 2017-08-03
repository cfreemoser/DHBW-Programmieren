package de.dhbwka.java.exercise.jbay;

import java.util.ArrayList;
import java.util.List;

public class Auktionshaus {
	List<Auktion> jbayAuctions = new ArrayList<Auktion>();
	public void addAuktion(Auktion a) {
		this.jbayAuctions.add(a);
	}
	public void removeAuction (Auktion a) {
		this.jbayAuctions.remove(a);
	}
	public List<Auktion> getAuktionen() {
		return this.jbayAuctions;
	}
}
