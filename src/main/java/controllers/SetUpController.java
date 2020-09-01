package controllers;

import displaySetUp.PlayerNamePanel;
import displaySetUp.PlayerRolePanel;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SetUpController implements ActionListener {

    private JFrame frame;
    private LoadFileUtil fu;
    private PlayerNamePanel pnp;
    private PlayerRolePanel prp;
    private JPanel playerCount;
    private JPanel playerName;
    private JPanel playerRole;
    private ArrayList<String> names;
    private ActionListener listener;
    private int playerTotal;
    private String path = "/Users/hannimpeha/HANNIMPEHA/Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";

    public SetUpController(JFrame frame, ActionListener listener) {
        this.frame = frame;
        this.listener = listener;
    }

    public void start() {
        fu = new LoadFileUtil();
        pnp = new PlayerNamePanel(this);
        prp = new PlayerRolePanel(this);
        playerName = pnp.getContentPane();
        playerRole = prp.getContentPane();
        playerTotal = 7;
        switchPanel(playerName);
    }

    private void switchPanel(JPanel panel) {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String name = source.getName();
            switch (name) {
                case "Player_Roles":
                    switchPanel(playerRole);
                    try {
                        Files.write(Paths.get(path), pnp.getPlayerNames());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    fu.newFile(pnp.getPlayerNames());
                    break;
                case "Game_Start":
                    System.out.println("Great");
                default:
                    break;
            }
    }

}