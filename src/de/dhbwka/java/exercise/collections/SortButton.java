package de.dhbwka.java.exercise.collections;

import javax.swing.*;

public class SortButton extends JButton {
	static final String AUTHOR="Author";
	static final String TITLE="Title";
	static final String YEAR="Year";
	static final String PUBLISHER="Publisher";

	String type;

	public SortButton(String sorting) {
		super(sorting);
		this.type=sorting;
	}
}
