package controllers;

import consoles.AppendTask;
import consoles.CommandListener;
import consoles.ConsolePane;
import consoles.Terminal;
import logic.Game;
import panels.DayPanel;
import panels.NightPanel;
import playerInfo.Player;

import javax.swing.*;
import java.util.List;


public class GameController  {

    private JFrame frame;
    private CommandListener listener;
    private Game g;
    private DayPanel dp;
    private NightPanel np;
    private List<Player> playerInfo;

    public GameController(JFrame frame, CommandListener listener) {
        this.frame = frame;
        this.listener = listener;
    }

    public void start() {
        g = new Game(playerInfo);
        dp = new DayPanel();
    }

}
