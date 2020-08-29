package controllers;

import consoles.ConsolePane;
import logic.Game;
import panels.DayPanel;
import panels.NightPanel;
import panels.VictoryPanel;
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
    private ConsolePane cp;

    public GameController(JFrame frame, ActionListener listener) {
        this.frame = frame;
        this.listener = listener;
    }

    public void start() {
        g = new Game(playerInfo);
        dp = new DayPanel(listener);
        np = new NightPanel(listener);
        vp = new VictoryPanel(listener);

        switchPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cp = new ConsolePane(listener);
        JTextArea source = (JTextArea) e.getSource();
        String name = source.getText();
        switch(name) {
            case "Game or Exit":
                switchPanel();
        }
    }

    private void switchPanel() {
        frame.setContentPane(cp);
    }
}
