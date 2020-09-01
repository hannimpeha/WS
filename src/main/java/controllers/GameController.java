package controllers;

import displayGame.DayPanel;
import displayGame.NightPanel;
import displayGame.VictoryPanel;
import logic.Game;
import playerInfo.Player;
import util.SaveFileUtil;

import javax.swing.*;
import java.awt.*;
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

    private JPanel panelDay;
    private JPanel panelNight;
    private JPanel panelVictory;
    private int position;

    private int target;

    public GameController(JFrame frame, ActionListener listener){
        this.frame = frame;
        this.listener = listener;
    }

    public void start(List<Player> playerInfo){

        g = new Game(playerInfo);
        dp = new DayPanel(this);
        np = new NightPanel(this);
        vp = new VictoryPanel(listener);

        fillPanels();

        panelNight = np.getContentPane();
        panelDay = dp.getContentPane();
        panelVictory = vp.getContentPane();

        target = -1;
        position = -1;

        switchPanel(panelDay);
    }

    private void fillPanels(){
        int y = 0;
        for(String name: g.getPlayerNames()){
            if(!name.contains("Dead")){
                dp.displayPlayerButton(name, y);
                np.displayPlayerButton(name, y);
            }
        }
    }

    private void switchDay(){
        target = -1;
        SaveFileUtil.saveGame(g.getPlayerInfo());
        switchPanel(panelDay);
    }

    private void switchNight(){
        //np.setDisplay(g.getPlayer(position));
        switchPanel(panelNight);
    }

    private void switchVictory(String victor){
        for(Player p: g.getPlayerInfo()){
           //vp.setPlayerInfo(p.copy());
        }
        //vp.setWinner(victor);
        switchPanel(panelVictory);
    }

    private void switchPanel(JPanel panel){
        JFrame frame = new JFrame("Hannah's Mafia Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();
        frame.setBounds(500, 20, 400, 430);
        frame.getContentPane().setVisible(false);
        frame.setContentPane(panel);
        frame.getContentPane().setVisible(true);
    }

    private void checkWinner(String time){
        String win = g.checkWinner();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String name = source.getName();
        switch (name) {
            case "Continue_ViewAllPlayersPanel":
                switchDay();
                break;
        }
    }
}
