package controllers;

import consoles.AppendTask;
import consoles.CommandListener;
import consoles.Terminal;
import panels.DayPanel;

import javax.swing.*;
import java.awt.*;

public class MainController implements CommandListener, Terminal {

    private JFrame frame;
    private CommandListener commandListener;
    private Terminal cmd;
    private DayPanel dp;
    private JTextArea textArea;

    public MainController(JFrame frame, CommandListener commandListener, Terminal cmd) {
        this.frame = frame;
        this.commandListener = commandListener;
        this.cmd = cmd;
    }

    public void start() {
        //textArea = new JTextArea(30, 30);
        //textArea.setVisible(true);
        //frame.add(textArea);
    }

    @Override
    public void commandOutput(String text) {
        SwingUtilities.invokeLater(new AppendTask(this, text));
    }

    @Override
    public void commandCompleted(String cmd, int result) {
        SwingUtilities.invokeLater(new AppendTask(this, "Command failed."));
    }

    @Override
    public void commandFailed(Exception exp) {
        appendText("\n> " + this + " exit.\n");
    }

    @Override
    public void appendText(String text) {
        this.appendText(text);
    }

    @Override
    public int getUserInputStart() {
        return 0;
    }
}
