package controllers;

import consoles.AppendTask;
import consoles.CommandListener;
import consoles.Terminal;
import logic.Game;
import panels.DayPanel;
import panels.NightPanel;
import playerInfo.Player;

import javax.swing.*;
import java.util.List;


public class GameController implements CommandListener, Terminal {

    private JFrame frame;
    private CommandListener commandListener;
    private Terminal cmd;
    private Game g;
    private DayPanel dp;
    private NightPanel np;
    private List<Player> playerInfo;

    public GameController(JFrame frame, CommandListener commandListener, Terminal cmd) {
        this.frame = frame;
        this.commandListener = commandListener;
        this.cmd = cmd;
    }

    public void start() {
        g = new Game(playerInfo);
        dp = new DayPanel();
        np = new NightPanel(commandListener);
    }

    @Override
    public void commandOutput(String text) {
        SwingUtilities.invokeLater(new AppendTask(this, text));
    }

    @Override
    public void commandCompleted(String cmd, int result) {
        SwingUtilities.invokeLater(new AppendTask(this, "Command failed."));
    }

    @Override
    public void commandFailed(Exception exp) {
        appendText("\n> " + cmd + " exit.\n");
    }

    @Override
    public void appendText(String text) {
        this.appendText(text);
    }

    @Override
    public int getUserInputStart() {
        return 0;
    }
}
