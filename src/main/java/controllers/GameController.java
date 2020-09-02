package controllers;

import logic.Game;
import panels.*;
import playerInfo.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameController implements ActionListener {

    private JFrame frame;
    private ActionListener listener;
    private Game g;
    private DayPanel dp;
    private NightPanel np;
    private VictoryPanel vp;
    private JPanel panelDay;
    private JPanel panelNight;
    private JPanel panelVictory;

    public GameController(JFrame frame, ActionListener listener) {
        this.frame = frame;
        this.listener = listener;
    }

    public void start(ArrayList<Player> playerInfo) {
        g = new Game(playerInfo);
        dp = new DayPanel(this);
        np = new NightPanel(this);
        vp = new VictoryPanel(this);
        panelDay = dp.getContentPane();
        panelNight = dp.getContentPane();
        panelVictory = vp.getContentPane();
        switchPanel(panelDay);
    }

    private void switchPanel(JPanel panel) {
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
            case "Game_Start":
                switchPanel(panelDay);
                break;
            case "Night_Start":
                switchPanel(panelNight);
                break;
            case "Check_Victory":
                switchPanel(panelVictory);
                break;
            default:
                break;
        }
    }
}
