package de.dhbwka.java.exercise.frames;

import javax.swing.*;

public class LabeledFrame2 {
	JFrame frame;

	public LabeledFrame2(){
		this.frame = new JFrame();
		this.frame.setTitle("Frame as instance of Class");
		this.frame.add(new JLabel("This Frame is created inside of the class"));
		this.frame.setSize(400, 200);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setVisible(true);
	}
}
