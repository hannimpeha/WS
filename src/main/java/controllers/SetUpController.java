package controllers;

import consoles.AppendTask;
import consoles.CommandListener;
import consoles.ConsolePane;
import consoles.Terminal;
import util.LoadFileUtil;

import javax.swing.*;
import java.io.FileNotFoundException;

public class SetUpController {

    private JFrame frame;
    private CommandListener listener;
    private LoadFileUtil fu;

    public SetUpController(JFrame frame, CommandListener listener) {
        this.frame = frame;
        this.listener = listener;
    }

    public void start() throws FileNotFoundException {
        fu = new LoadFileUtil();
        fu.newFile();
    }

}
