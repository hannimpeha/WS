package controllers;

import frames.CheckPlayerFrame;
import frames.DayFrame;
import frames.NightFrame;
import frames.VictoryFrame;
import logic.Game;
import playerInfo.Player;
import util.SaveFileUtil;

import javax.swing.*;
import java.awt.*;
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

    private Container panelDay;
    private Container panelNight;
    private Container panelCheckPlayer;
    private Container panelVictory;

    private int position;
    private boolean target;

    public GameController(JFrame frame, ActionListener globalListener) {
        this.frame = frame;
        this.globalListener = globalListener;
    }

    public void start(List<Player> playerInfo) throws FileNotFoundException {
        g = new Game(playerInfo);
        df = new DayFrame(this, globalListener);
        nf = new NightFrame(this, globalListener);
        cpf = new CheckPlayerFrame(globalListener);
        vf = new VictoryFrame(globalListener);

        fillPanels();

        panelDay = df.getContentPane();
        panelNight = df.getContentPane();
        panelCheckPlayer = cpf.getContentPane();
        panelVictory = vf.getContentPane();

        position = -1;
        target = false;

        switchPanel((JPanel) panelCheckPlayer);
    }

    private void fillPanels(){
        int y = 0;
        for(String name: g.getPlayerNames()){
            if(!name.contains("Dead")){
                df.displayPlayerButton(name, y);
                nf.displayPlayerButton(name, y);
            }
            cpf.displayPlayerButton(name, y);
            y++;
        }
    }
    private void switchPanel(JPanel panel){
        System.out.println("SWITCHING: "+panel.getName());
        frame.getContentPane().setVisible(false);
        frame.setContentPane(panel);
        frame.getContentPane().setVisible(true);
    }

    private void switchDay() throws FileNotFoundException {
        SaveFileUtil.saveGame(g.getPlayerInfo());
        switchPanel((JPanel) panelDay);
    }

    private void switchNight() throws FileNotFoundException {
        nf.setDisplay(g.getPlayer(position));
        switchPanel((JPanel) panelNight);
    }

    private void switchVictory(String victor) {
        for(Player p: g.getPlayerInfo()) {
            vf.setPlayerInfo(p.copy());
        }
        vf.setWinner(victor);
        switchPanel((JPanel) panelVictory);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        String name = source.getName();
        switch(name) {
            case "Day":
                try {
                    switchDay();
                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();
                }
                break;
            case "Night":
                try {
                    switchNight();
                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();
                }
                break;
        }
    }
}
