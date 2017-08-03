package de.dhbwka.java.exercise.collections;

import javax.swing.*;
import java.util.Set;

public class OutputWindow extends JFrame{

	public OutputWindow (String name, Set bookShelf) {
		this.setTitle(name);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.add(new JLabel("Have fun"));

		for (Object o:bookShelf) {
			if (o instanceof Book) {
				Book book = (Book)o;
				System.out.println(book.author + book.publisher + book.title + book.year);
			}
		}

		this.setVisible(true);
	}
}
