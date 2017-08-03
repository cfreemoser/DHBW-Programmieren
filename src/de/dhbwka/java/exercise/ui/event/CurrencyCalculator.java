package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyCalculator extends JFrame {
	JButton usdtoeuro = new CurrencyButton("USD=>EUR",CurrencyButton.DOLLAR);
	JButton eurotousd = new CurrencyButton("EUR=>USD", CurrencyButton.EURO);
	JButton stop = new JButton();
	JTextField input = new JTextField("Hier Betrag zum umrechnen eingeben");
	//CurrencyButtonListener cbl = new CurrencyButtonListener();

	ActionListener cbl2 = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			CurrencyButton but = (CurrencyButton) e.getSource();
			if (but.currency.equals(CurrencyButton.DOLLAR)) {
				System.out.println("Umrechnen von Dollar");
			} else {
				System.out.println("Umrechnen von Euro");
			}
		}
	};

	CurrencyCalculator() {
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(this.usdtoeuro);
		usdtoeuro.addActionListener(cbl2);
		this.add(this.eurotousd);
		eurotousd.addActionListener(cbl2);
		this.add(stop);
		this.add(input);

		this.setSize(400, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new CurrencyCalculator();
	}
}
