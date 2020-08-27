package controllers;

import consoles.CommandListener;
import consoles.ConsolePane;
import panels.DayPanel;

import javax.swing.*;

public class MainController {

    private JFrame frame;
    private CommandListener listener;
    private DayPanel dp;
    private JTextArea textArea;

    public MainController(JFrame frame, CommandListener listener) {
        this.frame = frame;
        this.listener = listener;
    }

    public void start() {
    }
}
