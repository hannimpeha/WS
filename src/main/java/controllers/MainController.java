package controllers;

import displayMain.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

    private JFrame frame;
    private ActionListener listener;
    private MainPanel mp;
    private JPanel panelMain;

    public MainController(JFrame frame, ActionListener listener) {
        this.frame = frame;
        this.listener = listener;
    }

    public void start() {
        mp = new MainPanel(this);
        panelMain = mp.getContentPane();
        switchPanel(panelMain);
    }

    private void switchPanel(JPanel panel) {
        JFrame frame = new JFrame("Hannah's Mafia Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();
        frame.setBounds(500, 20, 400, 430);
        frame.getContentPane().setVisible(false);
        frame.setContentPane(panel);
        frame.getContentPane().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        String name = source.getName();
        switch(name){
            case "Enter":
                switchPanel(panelMain);
                break;
            case "Back_AboutPanel":
                switchPanel(panelMain);
                break;
            case "Test_MainPanel":
                //switchTest();
            default:
                break;
        }
    }
}
