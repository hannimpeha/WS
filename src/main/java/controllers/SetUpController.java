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

    public SetUpController(String input) {
        dp = new DayPanel(input, round);
        np = new NightPanel(input);
    }

    public void start(int round) {
        dp = new DayPanel(input, round);
        gc = new GameController(input, round);
    }


    public void getPlayerNames() {
        System.out.println(fu.loadFile());
    }

    public List<String> getRoles() {
        return null;
    }
}
