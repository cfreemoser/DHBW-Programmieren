package de.dhbwka.java.exercise.ui.event;

import java.awt.event.*;

class CurrencyButtonListener implements ActionListener{

	CurrencyCalculator calc;

	public CurrencyButtonListener(CurrencyCalculator calc) {
		this.calc =calc;
	}

	public void actionPerformed(ActionEvent e){
		CurrencyButton but = (CurrencyButton) e.getSource();
		if (but.currency.equals(CurrencyButton.DOLLAR)) {
			System.out.println("Umrechnen von Dollar");
		} else {
			System.out.println("Umrechnen von Euro");
		}
	}
}
