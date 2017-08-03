package de.dhbwka.java.exercise.collections;

public class Book {
	String author;
	String title;
	String publisher;
	String year;

	public Book(String author, String title, String publisher, String year) {
		this.author=author;
		this.title=title;
		this.publisher=publisher;
		this.year=year;
	}
//TODO: implements Comparator and Override compareTo method
/*	@Override
	public int compareTo(Book otherBook) {

		return 0;
	}*/
}
