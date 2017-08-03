package de.dhbwka.java.exercise.t3_operators;

//http://www.iai.kit.edu/~javavorlesung/dhbw/2015-16/05_Operatoren_Aufgaben.pdf

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;

public class Easter_UI extends JFrame {
	JButton submit = new JButton("Submit");
	JTextField input = new JTextField();
	JCheckBox schaltjahr = new JCheckBox("Leap-Year info");

	public Easter_UI(){
		this.setSize(300,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Easter Calculator");

		this.setLayout(new BorderLayout(0,30));

		this.add(new JLabel("Please enter a year"), BorderLayout.NORTH);
		this.add(this.input, BorderLayout.CENTER);
		this.add(this.schaltjahr, BorderLayout.EAST);
		this.add(this.submit, BorderLayout.SOUTH);
		this.setVisible(true);

		this.submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String uinput = input.getText();
				int year;
				try {
					year = Integer.parseInt(uinput);
					String easter = new Easter(year).easter;
					if (schaltjahr.isSelected()) {
						JOptionPane.showMessageDialog(null, easter + new LeapYear(year).leap);
					}
					else {
						JOptionPane.showMessageDialog(null, easter);
					}
					Writer wr = new FileWriter("/home/vagrant/workspace/DHBW-Programmieren/easter_log.txt", true);
					wr.write(Calendar.getInstance().getTime().toString() + "; requested year: " + uinput + "; Easter date: " + easter);
					wr.write(System.lineSeparator());
					wr.close();
				}
				catch (IOException ioe) {
					JOptionPane.showMessageDialog(null, "Error!");
				}
				catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "This is the wrong format!");
				}
			}
		});
	}

	public static void main(String[] args) {
		new Easter_UI();
	}
}
