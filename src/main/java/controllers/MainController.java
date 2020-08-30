package controllers;

import consoles.ConsolePane;
import displayGame.DayPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

    private JFrame frame;
    private ActionListener listener;
    private ConsolePane cpName;
    private DayPanel dp;

    public MainController(JFrame frame, ActionListener listener) {
        this.frame = frame;
        this.listener = listener;
    }

    public void start() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cpName = new ConsolePane();
        JTextArea source = (JTextArea) e.getSource();
        String name = source.getText();
        switch(name) {
            case "Game or Exit":
                switchPanel(cpName);
        }
    }

    private void switchPanel(ConsolePane cpName) {
        frame.setContentPane(cpName);
    }
}
