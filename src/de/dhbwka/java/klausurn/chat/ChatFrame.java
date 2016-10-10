package de.dhbwka.java.klausurn.chat;

import de.dhbwka.java.klausurn.defaultStuff.JKlausurFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by cem on 05.10.16.
 */
abstract class ChatFrame extends JKlausurFrame {
    private final static String NICK_ACTION = "NICK_ACTION";
    private final static String WHO_ACTION = "WHO_ACTION";
    private final static String LOGOFF_ACTION = "LOGOFF_ACTION";
    private final static String CLEAR_BUTTON = "CLEAR_BUTTON";
    private final static String FINISHED_TYPING = "FINISHED_TYPING";

    private JTextArea area = new JTextArea(1, 1);
    private JTextField field = new JTextField();

    public ChatFrame(String title) {
        super(300, 300);
        this.setLayout(new BorderLayout());
        this.setTitle("#" + title);
        this.setPreferredSize(new Dimension(500, 500));
        JPanel buttonPanel = new JPanel();
        JButton nickButton = new JButton("Nick");
        nickButton.setActionCommand(NICK_ACTION);
        nickButton.addActionListener(this);
        JButton whoButton = new JButton("who?");
        whoButton.setActionCommand(WHO_ACTION);
        whoButton.addActionListener(this);
        JButton loggOffButton = new JButton("loggoff");
        loggOffButton.setActionCommand(LOGOFF_ACTION);
        loggOffButton.addActionListener(this);
        JButton clearButton = new JButton("clear");
        clearButton.setActionCommand(CLEAR_BUTTON);
        clearButton.addActionListener(this);
        buttonPanel.add(nickButton);
        buttonPanel.add(whoButton);
        buttonPanel.add(loggOffButton);
        buttonPanel.add(clearButton);

        JScrollPane scrollPane = new JScrollPane(area);

        field.setActionCommand(FINISHED_TYPING);
        field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    onSendMessage(field.getText());
                    field.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(field, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case NICK_ACTION:
                onNicknameChanged(JOptionPane.showInputDialog("Please select a new Nickname"));
                break;
            case WHO_ACTION:
                onWhoClicked();
                break;
            case LOGOFF_ACTION:
                onLogoffClicked();
                break;
            case CLEAR_BUTTON:
                onClearClicked();
                break;
        }
    }

    public void addText(String text) {
        area.append(text);
        area.append(System.lineSeparator());
    }

    public void newTitle(String title) {
        this.setTitle("#" + title);
    }

    protected abstract void onSendMessage(String text);

    protected abstract void onNicknameChanged(String nick);

    protected abstract void onWhoClicked();

    protected abstract void onLogoffClicked();

    protected void onClearClicked() {
        this.field.setText("");
        this.area.setText("");
    }
}
