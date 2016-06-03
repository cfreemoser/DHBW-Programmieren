package de.dhbwka.java.exercise.frames;

import javax.swing.*;

public class LabeledFrame {

	public static void main(String[] args) {
		JFrame myFrame = new JFrame();
		myFrame.setTitle("This is my labeled Frame");
		myFrame.add(new JLabel("Hello frame world!"));
		myFrame.setSize(300, 150);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);

		// Creates a labeled Frame as a component of a new class.
		//new LabeledFrame2();

		// Creates a labeled Frame as a separate class extending JFrame.
		//new LabeledFrame3();

		new MultiButtonFrame();
	}
}
