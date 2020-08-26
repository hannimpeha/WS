package controllers;

import panels.DayPanel;
import panels.NightPanel;
import util.LoadFileUtil;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class SetUpController {

    private String input;
    private BufferedReader br;
    private DayPanel dp;
    private NightPanel np;
    private LoadFileUtil fu;
    private int round;
    private GameController gc;
    private String playerLine;

    public SetUpController(String input, int round, String playerLine) {
        this.playerLine = playerLine;
        this.input = input;
        dp = new DayPanel(playerLine, round, playerLine);
        np = new NightPanel(input);
    }

    public String start(int round) throws IOException {
        dp = new DayPanel(input, round, playerLine);
        gc = new GameController(dp.start(round).readLine(), round);
        return input;
    }


    public void getPlayerNames() {
        System.out.println(fu.loadFile());
    }

    public List<String> getRoles() {
        return null;
    }
}
