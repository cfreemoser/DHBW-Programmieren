package de.dhbwka.java.exercise.ui.paint;

import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This is the Class of the JFrame which is going to ask for data

public class Election extends JFrame implements ActionListener{
	private final int NUMBER_OF_PARTIES = 8;
	private final String[] COLORS = {"black","red","blue","yellow","green","brown","pink","orange"};
	public JTextField[] fieldNames = new JTextField[NUMBER_OF_PARTIES];
	public JFormattedTextField[] fieldPercent = new JFormattedTextField[NUMBER_OF_PARTIES];
	public JComboBox[] fieldColor = new JComboBox[NUMBER_OF_PARTIES];
	public Party[] parties = new Party[NUMBER_OF_PARTIES];

//Constructor for the main Class - Election
	public Election(){
		this.setTitle("Parties");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,600);
		this.setLayout(new BorderLayout(5, 5));

		JPanel top = new JPanel();
		top.setLayout(new GridLayout(NUMBER_OF_PARTIES+1,3,10,10));
		top.add(new JLabel("Name of the Party"));
		top.add(new JLabel("Choose color"));
		top.add(new JLabel("Result"));

	//Creating the input-fields for parties
		for (int i=0; i<NUMBER_OF_PARTIES; i++) {
			this.fieldNames[i] = new JTextField();
			this.fieldPercent[i] = new JFormattedTextField();

//TODO: Format the JFormattedTextField to accept doubles only

			this.fieldColor[i] = new JComboBox(COLORS);
			top.add(this.fieldNames[i]);
			top.add(this.fieldColor[i]);
			top.add(this.fieldPercent[i]);
		}

		this.add(top,BorderLayout.NORTH);

		JButton goButton = new JButton("Go");
		goButton.addActionListener(this);
		this.add(goButton, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
	}



	public static void main(String[] args) {
		new Election();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<NUMBER_OF_PARTIES; i++) {
			this.parties[i]=new Party(this.fieldNames[i].getText(), this.fieldColor[i].getSelectedItem().toString(), this.fieldPercent[i].getText());
			System.out.println("Party number " + i + " " + this.parties[i].name + " " + this.parties[i].color + " " + this.parties[i].percent);
		}
	}
}