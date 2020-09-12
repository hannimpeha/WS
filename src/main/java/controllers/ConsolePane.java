package controllers;

import graphViz.NCT;
import jason.infra.centralised.RunCentralisedMAS;
import org.neo4j.graphdb.Node;
import panels.DayPanel;
import panels.NightPanel;
import panels.PlayerNames;
import panels.PlayerRoles;
import playerInfo.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public abstract class ConsolePane extends JPanel {

    public List<Player> playerInfo;
    public List<Node> playerNode;
    public PlayerNames pnp = new PlayerNames();
    public PlayerRoles prp = new PlayerRoles();
    public DayPanel dp = new DayPanel();
    public NightPanel np = new NightPanel();
    private List<String> playerName;
    private static JPanel contentPane = new JPanel();
    private static JPanel north = new JPanel();
    private static JPanel south = new JPanel();
    private JPanel PlayerNames = new JPanel();
    private static  String path = "/Users/hannimpeha/HANNIMPEHA/" +
            "Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";

    public ConsolePane() {
        displayNorth();
        displaySouth();
    }

    public void initFrame() {
        JFrame frame = new JFrame("Hannah's Mafia Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 20, 400, 450);
        frame.setLocationRelativeTo(null);
        frame.add(north, BorderLayout.CENTER);
        frame.add(south, BorderLayout.PAGE_END);
        frame.pack();
        frame.setVisible(true);
    }

    private void displayNorth(){
        north.setLayout(new CardLayout(20, 20));
        north.add(new JScrollPane(pnp.createPanel()));
        north.add(new JScrollPane(prp.createPanel()));
        north.add(new JScrollPane(dp.createPanel()));
        north.add(new JScrollPane(np.createPanel()));
        contentPane.add(north);
    }

    private void displaySouth() {
        final Box box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        final JTextField textField = new JTextField(24);
        box.add(textField);
        JButton button = new JButton("Enter");
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) north.getLayout();
                cardLayout.next(north);
                playerName = Arrays.asList(textField.getText().split(", "));
                try {
                    Files.write(Paths.get(path),playerName);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        final JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RunCentralisedMAS();
                new NCT(playerInfo = setAllPlayers(),
                        playerNode = setAllNodes());
                saveGame();
            }

            @Override
            public List<Player> setAllPlayers() {
                return prp.setAllPlayers();
            }

            @Override
            public List<Node> setAllNodes() {
                return prp.setAllNodes();
            }

            @Override
            public void saveGame() {
                prp.saveGame(playerInfo);
            }
        });

        box.add(button);
        box.add(sendButton);
        south.add(box);
        contentPane.add(south);
    }

    public static JPanel getContentPane(){ return contentPane; }
    public static JPanel getNorthPane() { return north; }
    public static JPanel getSouthPane() { return south; }
}