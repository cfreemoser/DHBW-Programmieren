package de.dhbwka.java.exercise.jbay;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class BieterTerminal extends JFrame {

	public BieterTerminal(Bieter bieter, Auktionshaus ah) {
		this.setTitle(bieter.getFullName() + "'s Terminal");
		this.setSize(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		//Upper JPanel (for time)
		JPanel top = new JPanel();
		top.add(new JLabel(Calendar.getInstance().getTime().toString()));
		//Downer JPanel (for Grid Interface)
		JPanel bottom = new JPanel();
		int numberAuctions = ah.jbayAuctions.size();
		bottom.setLayout(new GridLayout(numberAuctions,5,1,1));
		JLabel ware[] = new JLabel[numberAuctions];
		JLabel price[] = new JLabel[numberAuctions];
		JLabel better[] = new JLabel[numberAuctions];
		JLabel ending[] = new JLabel[numberAuctions];
		GebotButton giveBet[] = new GebotButton[numberAuctions];
		for (int i = 0; i < numberAuctions; i++) {
			ware[i] = new JLabel(ah.getAuktionen().get(i).ware.title);
			price[i] = new JLabel(String.valueOf(ah.getAuktionen().get(i).price));
			if (ah.getAuktionen().get(i).bet==null) {
				better[i]=new JLabel("---");
			}
			else {
				better[i] = new JLabel(ah.getAuktionen().get(i).bet.better.getFullName());
			}
			ending[i] = new JLabel(ah.getAuktionen().get(i).ending.getTime().toString());
			giveBet[i] = new GebotButton("Gebot",ah.getAuktionen().get(i),bieter);
			bottom.add(ware[i]);
			bottom.add(price[i]);
			bottom.add(better[i]);
			bottom.add(ending[i]);
			bottom.add(giveBet[i]);
			giveBet[i].addActionListener(new GebotButtonListener());
			//Adding Panels to the window
			this.add(top, BorderLayout.NORTH);
			this.add(bottom, BorderLayout.SOUTH);
			this.pack();
			this.setVisible(true);
		}
	}
}

