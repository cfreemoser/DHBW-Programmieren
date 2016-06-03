package de.dhbwka.java.exercise.frames;

import javax.swing.*;

public class LabeledFrame3 extends JFrame {
	public LabeledFrame3() {
		this.setTitle("This frame extends JFrame");
		this.add(new JLabel("Yeah, nothing to see here."));
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
