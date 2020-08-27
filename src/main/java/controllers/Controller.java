package controllers;

import consoles.*;
import javax.swing.*;
import java.awt.*;

public class Controller {

    private JFrame frame;
    private MainController mc;
    private SetUpController suc;
    private GameController gc;
    private ConsolePane cp;

    public Controller() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                createFrame();
            }
        });
    }

    public void run() {
        mc = new MainController(frame, cp);
        suc = new SetUpController(frame, cp);
        gc = new GameController(frame,  cp);
        mc.start();
    }

    public void createFrame() {
        JFrame frame = new JFrame("Hannah's Mafia Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new ConsolePane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

