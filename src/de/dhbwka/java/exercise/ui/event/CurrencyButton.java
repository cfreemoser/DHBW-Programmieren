package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;

/**
 * Created by vagrant on 6/16/16.
 */
public class CurrencyButton extends JButton {

	static final String EURO = "EURO";
	static final String DOLLAR = "DOLLAR";

	String currency;

	public CurrencyButton(String buttontext, String currency) {
		super(buttontext);
		this.currency = currency;
	}

}




