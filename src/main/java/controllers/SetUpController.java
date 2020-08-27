package controllers;

import consoles.AppendTask;
import consoles.CommandListener;
import consoles.Terminal;
import util.LoadFileUtil;

import javax.swing.*;

public class SetUpController implements CommandListener, Terminal {

    private JFrame frame;
    private CommandListener commandListener;
    private Terminal cmd;
    private LoadFileUtil fu;

    public SetUpController(JFrame frame, CommandListener commandListener, Terminal cmd) {
        this.frame = frame;
        this.commandListener = commandListener;
        this.cmd = cmd;
    }


    public void start() {
        fu = new LoadFileUtil();
        fu.newFile();
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
        appendText("\n> " + cmd + " exit.\n");
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
