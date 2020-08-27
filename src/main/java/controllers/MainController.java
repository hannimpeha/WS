package controllers;

import consoles.ConsolePane;
import panels.DayPanel;

import javax.swing.*;

public class MainController {

    private JFrame frame;
    private ConsolePane cp;
    private DayPanel dp;
    private JTextArea textArea;

    public MainController(JFrame frame, ConsolePane cp) {
        this.frame = frame;
        this.cp = cp;
    }

    public void start() {
        System.out.println("Game or Exit");
    }
}
