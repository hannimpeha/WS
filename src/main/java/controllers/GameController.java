package controllers;

import consoles.CommandListener;
import logic.Game;
import panels.DayPanel;
import panels.NightPanel;
import playerInfo.Player;

import javax.swing.*;
import java.util.List;


public class GameController implements CommandListener {

    private JFrame frame;
    private CommandListener commandListener;
    private Game g;
    private DayPanel dp;
    private NightPanel np;
    private List<Player> playerInfo;

    public GameController(JFrame frame, CommandListener commandListener) {
        this.frame = frame;
        this.commandListener = commandListener;
    }

    public void start() {
        g = new Game(playerInfo);
        dp = new DayPanel();
        np = new NightPanel(commandListener);
    }

    @Override
    public void commandOutput(String text) {
    }

    @Override
    public void commandCompleted(String cmd, int result) {
    }

    @Override
    public void commandFailed(Exception exp) {
    }

}
