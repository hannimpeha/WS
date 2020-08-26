package controllers;

import logic.Game;
import panels.DayPanel;
import panels.NightPanel;
import panels.VictoryPanel;
import playerInfo.Player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController {

    private Game g;
    private String input;
    private DayPanel dp;
    private NightPanel np;
    private VictoryPanel vp;
    private BufferedReader br;
    private InputStreamReader ir;
    private int round;
    private String playerLine;

    public GameController(String input, int round)  {
        this.input = input;
        this.round = round;
    }

    public void nightsToCome()  {
        np = new NightPanel(input);
        np.start();
    }

    public void daysToCome(int round) {
        while(round>0) {
            dp = new DayPanel(input, round, playerLine);
            dp.start(round);
        }
    }

    private void switchVictory(String victor) {
        for(Player p: g.getPlayerInfo()) {
            vp.setPlayerInfo(p.copy());
        }
        vp.setWinner(victor);
    }

}
