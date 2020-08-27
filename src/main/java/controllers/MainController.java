package controllers;

import consoles.AppendTask;
import consoles.CommandListener;
import consoles.ConsolePane;
import panels.DayPanel;

import javax.swing.*;

public class MainController implements CommandListener {

    private JFrame frame;
    private CommandListener commandListener;
    private DayPanel dp;

    public MainController(JFrame frame, CommandListener commandListener) {
        this.frame = frame;
        this.commandListener = commandListener;
    }

    public void start() {
        new ConsolePane();
        //frame.add(dp);
    }

    @Override
    public void commandOutput(String text) {
        SwingUtilities.invokeLater(new AppendTask(dp, text));
    }

    @Override
    public void commandCompleted(String cmd, int result) {
    }

    @Override
    public void commandFailed(Exception exp) {
    }

}
