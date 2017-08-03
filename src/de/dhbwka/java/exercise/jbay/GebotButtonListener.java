package de.dhbwka.java.exercise.jbay;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class GebotButtonListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		GebotButton b = (GebotButton) e.getSource();
		if (b.auc.ending.before(Calendar.getInstance())){
			JOptionPane.showMessageDialog(null, "Die Auktion ist leider schon vorbei...");
		}
		else {
			double bet;
			String input = (String)JOptionPane.showInputDialog("Bitte neues Gebot eingeben.", (b.auc.price + b.auc.INCREMENT));
			try {
			bet=Double.parseDouble(input);
			System.out.println(bet);}
			catch (NumberFormatException nfe){
				bet=0.0;
			}
			if(b.auc.gebotAbgeben(new Gebot(bet,b.bit))) {
				JOptionPane.showMessageDialog(null,"Sie sind Höchstbietender!");
			}
			else {
				JOptionPane.showMessageDialog(null, "Gebot zu gering!");
			}
		}
	}
}
