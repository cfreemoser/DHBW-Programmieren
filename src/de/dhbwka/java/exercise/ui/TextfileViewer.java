package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;

public class TextfileViewer {

	public void readMe (String absolutePath, String name) {
		StringBuffer bufferL = new StringBuffer();
		StringBuffer bufferS = new StringBuffer();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(absolutePath));
				int count = 0;
				while (reader.ready()) {
					bufferL.append(reader.readLine());
					bufferL.append(System.lineSeparator());
					count++;
					if (count == 10) {
						bufferS.append(bufferL);
					}
				}

		} catch (IOException e) {
			e.printStackTrace();
		}
		showMeNormally(bufferL, name);
		showMeLikeImYourLabel(bufferS, name);
	}

	public static void main(String[] args) {
		TextfileViewer myViewer = new TextfileViewer();

		JFileChooser myFiles = new JFileChooser();

		myFiles.setFileFilter(new FileFilter() {
			@Override
			public boolean accept(File f) {
				return f.isDirectory() ||
						f.getName().endsWith(".txt");
			}

			@Override
			public String getDescription() {
				return "*.txt";
			}
		});

		int state = myFiles.showOpenDialog(null);

		if (state == JFileChooser.APPROVE_OPTION){
			String filePath = myFiles.getSelectedFile().getAbsolutePath();
			String name = myFiles.getSelectedFile().getName();
			JOptionPane.showMessageDialog(null, "Your file: " + filePath);
			myViewer.readMe(filePath, name);
		}
		else {
			JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void showMeNormally(StringBuffer text, String name) {
		JFrame normal = new JFrame();
		normal.setTitle(name);
		normal.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		normal.setSize(500, 500);
		normal.setVisible(true);

		JTextArea area = new JTextArea(text.toString());
		//JScrollPane scrolly = new JScrollPane(area);
		normal.add(area);
		System.out.println(text.toString());
	}
	private void showMeLikeImYourLabel(StringBuffer text, String name) {
		JFrame likeALabel = new JFrame();
		likeALabel.setTitle(name);
		likeALabel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		likeALabel.setSize(300, 300);
		likeALabel.setVisible(true);

		likeALabel.add(new JButton("Ok"));
	}
}
