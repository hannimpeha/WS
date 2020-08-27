package controllers;

import consoles.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Controller {

    private JFrame frame;
    private MainController mc;
    private SetUpController suc;
    private GameController gc;
    private CommandListener listener;

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

    public void run() throws FileNotFoundException {
        mc = new MainController(frame, listener);
        suc = new SetUpController(frame, listener);
        gc = new GameController(frame,  listener);
        suc.start();
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

