package controllers;

import panels.DayPanel;
import panels.NightPanel;
import panels.VictoryPanel;
import panels.MainPanel;
import panels.PlayerNamePanel;
import panels.PlayerRolePanel;
import logic.Game;
import playerInfo.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MainController implements ActionListener {

    private JFrame frame;
    private ActionListener listener;
    private GameController gc;
    private MainPanel mp;
    private PlayerNamePanel pnp;
    private PlayerRolePanel prp;
    private JPanel panelMain;
    private JPanel playerName;
    private JPanel playerRole;
    private ArrayList<Player> playerInfo;
    private String path = "/Users/hannimpeha/HANNIMPEHA/" +
            "Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";

    public MainController(JFrame frame, ActionListener listener) {
        this.frame = new JFrame("Hannah's Mafia Game");
        this.listener = listener;
    }

    public void start() {
        mp = new MainPanel(this);
        pnp = new PlayerNamePanel(this);
        prp = new PlayerRolePanel(this);
        panelMain = mp.getContentPane();
        playerName = pnp.getContentPane();
        playerRole = prp.getContentPane();
        switchPanel(panelMain);
    }

    private void switchPanel(JPanel panel) {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        String name = source.getName();
        switch(name){
            case "Player_Names":
                switchPanel(playerName);
                break;
            case "Player_Roles":
                try {
                    Files.write(Paths.get(path), pnp.getPlayerNames());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                switchPanel(playerRole);
                break;
            default:
                break;
        }
    }
}