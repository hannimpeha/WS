package controllers;

import frames.DayFrame;

import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

    private ActionListener packageListener;
    private ActionListener globalListener;
    private JFrame frame;
    private LoadFileUtil fu;
    private SetUpController suc;
    private GameController gc;
    private DayFrame df;

    public MainController(JFrame frame, ActionListener globalListener) {
        this.frame = frame;
        this.globalListener = globalListener;
    }

    public void start() {
        df.getContentPane();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
