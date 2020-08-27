package controllers;

import consoles.AppendTask;
import consoles.CommandListener;
import util.LoadFileUtil;

import javax.swing.*;

public class SetUpController implements CommandListener {

    private JFrame frame;
    private CommandListener commandListener;
    private LoadFileUtil fu;

    public SetUpController(JFrame frame, CommandListener commandListener) {
        this.frame = frame;
        this.commandListener = commandListener;
    }


    public void start() {
        fu = new LoadFileUtil();
        fu.newFile();
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
