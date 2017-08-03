package de.dhbwka.java.exercise.jbay;

import javax.swing.*;

public class GebotButton extends JButton {
	Auktion auc;
	Bieter bit;

	public GebotButton(String text, Auktion a, Bieter b){
		super(text);
		this.auc = a;
		this.bit=b;
	}
}
