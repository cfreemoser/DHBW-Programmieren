package de.dhbwka.java.exercise.collections;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SortButtonListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		Set bookShelf = new TreeSet();

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/vagrant/workspace/DHBW-Programmieren/lib.txt"));
		SortButton but = (SortButton) e.getSource();

		//Read a bookshelf from a file
			while (bufferedReader.ready()) {
				String author = bufferedReader.readLine().split(",").toString();
				String title = "cucumber";
				String publisher = "cucumber2";
				String year = "cucumber3";

				bookShelf.add(new Book(author, title, publisher, year));
			}
			bufferedReader.close();

		//Switch through sorting-options and send the output to Output-Window;
			switch (but.type) {
				case SortButton.AUTHOR :
				System.out.println("Sortieren nach " + SortButton.AUTHOR);

				new OutputWindow("Library sorted by" + SortButton.AUTHOR, bookShelf);
				break;
			case SortButton.PUBLISHER :
				System.out.println("Sortieren nach " + SortButton.PUBLISHER);
				break;
			case SortButton.TITLE :
				System.out.println("Sortieren nach " + SortButton.TITLE);
				break;
			default :
				System.out.println("Sortieren nach " + SortButton.YEAR);
				break;
		}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
