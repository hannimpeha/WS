package controllers;

import consoles.ConsolePane;
import panels.DayPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

    private JFrame frame;
    private ActionListener listener;
    private ConsolePane cp;
    private DayPanel dp;

    public MainController(JFrame frame, ActionListener listener) {
        this.frame = frame;
        this.listener = listener;
    }

    public void start() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cp = new ConsolePane(listener);
        JTextArea source = (JTextArea) e.getSource();
        String name = source.getText();
        switch(name) {
            case "Game or Exit":
                switchPanel();
        }
    }

    private void switchPanel() {
        frame.setContentPane(cp);
    }
}
