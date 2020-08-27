package controllers;

import consoles.ConsolePane;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.*;

public class Controller {

    private LoadFileUtil fu;
    private ConsolePane cp;

    public void Controller() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }

            JFrame frame = new JFrame("Hannah's Mafia Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(new ConsolePane());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public void run() {

    }

}
