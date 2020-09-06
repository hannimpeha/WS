package controllers;

import logic.Game;
import playerInfo.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameController {

    private JFrame frame;
    private ActionListener listener;
    private Game g;
    private JPanel panelDay;
    private JPanel panelNight;
    private JPanel panelVictory;

    public GameController(JFrame frame) {
        this.frame = frame;
    }

    public void start(ArrayList<Player> playerInfo) {
        g = new Game(playerInfo);
        switchPanel(panelDay);
    }

    private void switchPanel(JPanel panel) {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();
        frame.setBounds(500, 20, 400, 430);
        frame.getContentPane().setVisible(false);
        frame.setContentPane(panel);
        frame.getContentPane().setVisible(true);
    }

}
