package controllers;


import frames.CheckPlayerFrame;
import frames.DayFrame;
import frames.NightFrame;
import frames.VictoryFrame;
import logic.Game;
import playerInfo.Player;
import util.SaveFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

public class GameController implements ActionListener {

    private JFrame frame;
    private ActionListener globalListener;
    private Game g;
    private DayFrame df;
    private NightFrame nf;
    private CheckPlayerFrame cpf;
    private VictoryFrame vf;
    private int position;
    private boolean target;

    public GameController(JFrame frame, ActionListener globalListener) {
        this.frame = frame;
        this.globalListener = globalListener;
    }

    public void start(List<Player> playerInfo) throws FileNotFoundException {
        g = new Game(playerInfo);
        df = new DayFrame(globalListener);
        nf = new NightFrame(globalListener);
        cpf = new CheckPlayerFrame(globalListener);
        vf = new VictoryFrame(globalListener);

        position = -1;
        target = false;

        switchDay();
    }

    private void switchDay() throws FileNotFoundException {
        SaveFileUtil.saveGame(g.getPlayerInfo());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
