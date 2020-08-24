package controllers;

import frames.DayFrame;
import frames.MainFrame;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.keyboard.NativeKeyEvent;

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
    private MainFrame mf;

    public MainController(JFrame frame, ActionListener globalListener) {
        this.frame = frame;
        this.globalListener = globalListener;
    }

    public void start() {
        mf = new MainFrame(globalListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
