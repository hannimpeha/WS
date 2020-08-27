package controllers;

import consoles.AppendTask;
import consoles.CommandListener;
import consoles.ConsolePane;
import consoles.Terminal;
import util.LoadFileUtil;

import javax.swing.*;

public class SetUpController {

    private JFrame frame;
    private ConsolePane cp;
    private LoadFileUtil fu;

    public SetUpController(JFrame frame, ConsolePane cp) {
        this.frame = frame;
        this.cp = cp;
    }

    public void start() {
        fu = new LoadFileUtil();
        fu.newFile();
    }

}
