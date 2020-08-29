package controllers;

import consoles.CommandListener;
import util.LoadFileUtil;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SetUpController {

    private JFrame frame;
    private CommandListener listener;
    private LoadFileUtil fu;

    public SetUpController(JFrame frame, CommandListener listener) {
        this.frame = frame;
        this.listener = listener;
    }

    public void start() throws IOException {
        fu = new LoadFileUtil();

    }

}
