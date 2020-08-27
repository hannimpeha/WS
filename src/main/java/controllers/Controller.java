package controllers;

import consoles.CommandListener;
import consoles.ConsolePane;
import util.LoadFileUtil;
import javax.swing.*;
import java.awt.*;

public class Controller implements CommandListener {

    private JFrame frame;
    private LoadFileUtil fu;
    private MainController mc;
    private GameController gc;
    private SetUpController suc;

    public void Controller() {
        createFrame();
    }

    public void run() {
        mc = new MainController(frame, this);
        gc = new GameController(frame,  this);
        suc = new SetUpController(frame, this);
        mc.start();
    }

    public void createFrame() {
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
    @Override
    public void commandOutput(String text) {
    }

    @Override
    public void commandCompleted(String cmd, int result) {
    }

    @Override
    public void commandFailed(Exception exp) {
    }
}
