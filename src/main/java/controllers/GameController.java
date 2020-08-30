package controllers;

import consoles.ConsolePane;
import logic.Game;
import displayGame.DayPanel;
import displayGame.NightPanel;
import displayGame.VictoryPanel;
import playerInfo.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class GameController implements ActionListener {

    private JFrame frame;
    private ActionListener listener;
    private Game g;
    private DayPanel dp;
    private NightPanel np;
    private VictoryPanel vp;
    private List<Player> playerInfo;
    private ConsolePane cpName;

    public GameController(JFrame frame, ActionListener listener) {
        this.frame = frame;
        this.listener = listener;
    }

    public void start(List<Player> playerInfo) {
        g = new Game(playerInfo);
        dp = new DayPanel(this, listener);
        np = new NightPanel(this, listener);
        vp = new VictoryPanel(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cpName = new ConsolePane();
        JTextArea source = (JTextArea) e.getSource();
        String name = source.getText();
        switch(name) {
            case "Game or Exit":
                switchPanel(cpName);
        }
    }

    private void switchPanel(ConsolePane cpName) {
        frame.setContentPane(cpName);
    }
}
