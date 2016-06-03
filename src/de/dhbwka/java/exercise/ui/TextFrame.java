package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.io.*;

public class TextFrame extends JFrame{

	public TextFrame (String name, int width, int height) {
		this.setTitle(name);
		this.setSize(width, height);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		TextFrame frame = new TextFrame(args[0].substring(42), Integer.valueOf(args[1]), Integer.valueOf(args[2]));

		try {
			BufferedReader myReader = new BufferedReader(new FileReader(args[0]));
			StringBuffer buffer = new StringBuffer();

			BufferedReader myReader2 = new BufferedReader(new FileReader(args[0]));
			long l = myReader2.lines().count();
			myReader2.close();

			for (int i = 0; i < l; i++) {
				buffer.append(myReader.readLine());
				buffer.append(System.lineSeparator());
			}

			frame.method(buffer.toString());

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void method (String s) {
		JTextArea area = new JTextArea();
		this.add(area);
		area.setText(s);
	}
}
