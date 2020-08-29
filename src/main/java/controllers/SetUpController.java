package controllers;

import consoles.ConsolePane;
import util.LoadFileUtil;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetUpController implements ActionListener {

    private JFrame frame;
    private ConsolePane cp;
    private ActionListener listener;
    private LoadFileUtil fu;

    public SetUpController(JFrame frame, ActionListener listener) {
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
            case "game":
                switchPanel();
        }
    }

    private void switchPanel() {
        frame.setContentPane(cp);
    }
}
