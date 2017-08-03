package de.dhbwka.java.exercise.collections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Library extends JFrame {

	public JTextField[] input = new JTextField[4];
	public JLabel[] labels = new JLabel[4];
	JButton title = new SortButton("Title");
	JButton author = new SortButton("Author");
	JButton publisher = new SortButton("Publisher");
	JButton year = new SortButton("Year");

//Constructor for the main window
	public Library(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("New Book");
		this.setSize(500, 180);

		this.setLayout(new BorderLayout());
	//Upper JPanel (for input)
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(4, 2));
		for (int i=0; i<input.length; i++) {
			input[i]=new JTextField();
			labels[i]=new JLabel();
			top.add(labels[i]);
			top.add(input[i]);
		}

		labels[0].setText("Titel");
		labels[1].setText("Author");
		labels[2].setText("Jahr");
		labels[3].setText("Verlag");

		this.add(top, BorderLayout.NORTH);

	//Middle JPanel for saving entry
		JPanel mid = new JPanel();
		JButton save = new JButton("Eintrag speichern");
		mid.add(save);
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/vagrant/workspace/DHBW-Programmieren/lib.txt",true)));
					for (int i=0; i<4; i++) {
						bufferedWriter.write(input[i].getText().toString());
						if (i<3) {
							bufferedWriter.write(",");
						}
					}
					bufferedWriter.write(";");
					bufferedWriter.newLine();
					bufferedWriter.close();
				} catch (IOException e1) {
					e1.printStackTrace(); }
			}
		});
		this.add(mid, BorderLayout.CENTER);

	//Bottom JPanel for sorting entries
		JPanel bot = new JPanel();
		bot.add(new JLabel("Sortieren nach"));
		bot.add(this.author);
		author.addActionListener(new SortButtonListener());
		bot.add(this.title);
		title.addActionListener(new SortButtonListener());
		bot.add(this.publisher);
		publisher.addActionListener(new SortButtonListener());
		bot.add(this.year);
		year.addActionListener(new SortButtonListener());

		this.add(bot, BorderLayout.SOUTH);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Library();
	}
}
