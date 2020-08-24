package controllers;

import frames.AboutFrame;
import frames.DayFrame;

import frames.MainFrame;
import frames.RuleFrame;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

    private ActionListener packageListener;
    private ActionListener globalListener;
    private JFrame frame;
    private MainFrame mf;
    private RuleFrame rf;
    private AboutFrame af;
    private Container panelMain;
    private Container panelRule;
    private Container panelAbout;

    public MainController(JFrame frame, ActionListener globalListener) {
        this.frame = frame;
        this.globalListener = globalListener;
    }

    public void start() {
        mf = new MainFrame(this);
        rf = new RuleFrame(this);
        af = new AboutFrame(this);

        panelMain = mf.getContentPane();
        panelRule = rf.getContentPane();
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
