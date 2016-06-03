package de.dhbwka.java.exercise.frames;

import javax.swing.*;

public class MultiButtonFrame {
	JFrame frame;

	public MultiButtonFrame() {
		this.frame = new JFrame();
		JPanel jp = new JPanel();

		for (int i=1; i<=3; i++) {
			jp.add(new JButton("Button" + i));
		}

		this.frame.add(jp);
		this.frame.setTitle("MultiButton Frame");
		this.frame.setSize(400, 200);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setVisible(true);
	}
}
