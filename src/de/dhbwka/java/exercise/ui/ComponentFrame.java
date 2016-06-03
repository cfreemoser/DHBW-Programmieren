package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ComponentFrame extends JFrame {
	public ComponentFrame() {
		JPanel myPanel = new JPanel();

		myPanel.add(new JLabel("Name"));

		JTextField textfield = new JTextField("Type something");
		myPanel.add(textfield);
		textfield.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				textfield.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textfield.getText().equals("")) {
					textfield.setText("Type something");
					textfield.setDisabledTextColor(Color.gray);
				}
			}
		});

		myPanel.add(new JPasswordField("xxxxxxxxxxxxx"));

		JButton click = new JButton("Click me");
		myPanel.add(click);
		click.setToolTipText("Click to have fun clicking");

		myPanel.add(new JToggleButton("Click me, i toggle"));

		myPanel.add(new Checkbox());

		JComboBox<String> myBox = new JComboBox<>();
		myBox.addItem("Choose me");
		myBox.addItem("No, me!");
		myBox.addItem("Choose option 2");

		myPanel.add(myBox);

		ButtonGroup myGroup = new ButtonGroup();
		for (int i=1; i<=3; i++) {
			JRadioButton radio = new JRadioButton("radio" + i);
			myPanel.add(radio);
			myGroup.add(radio);
		}

		this.add(myPanel);
		this.setSize(600, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ComponentFrame();
	}
}
