package controllers;

import frames.AboutFrame;

import frames.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

    private ActionListener packageListener;
    private ActionListener globalListener;
    private JFrame frame;
    private MainFrame mf;
    private AboutFrame af;
    private Container panelMain;
    private Container panelRule;
    private Container panelAbout;

    public MainController(JFrame frame, ActionListener globalListener) {
        this.frame = frame;
        this.globalListener = globalListener;
    }

    public void start() {
        mf = new MainFrame(globalListener);
        af = new AboutFrame(globalListener);

        panelMain = mf.getContentPane();
        panelAbout = af.getContentPane();

        switchPanel((JPanel) panelMain);
    }

    private void switchPanel(JPanel panel){
        System.out.println("SWITCHING: "+panel.getName());
        frame.getContentPane().setVisible(false);
        frame.setContentPane(panel);
        frame.getContentPane().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String name = source.getName();
        switch (name) {
            case "Back_RulePanel":
                switchPanel((JPanel) panelMain);
                break;
            case "Rule_MainPanel":
                switchPanel((JPanel) panelRule);
                break;
            case "About_MainPanel":
                switchPanel((JPanel) panelAbout);
        }
    }
}
