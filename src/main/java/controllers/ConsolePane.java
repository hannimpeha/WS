package controllers;

import jason.Agents;
import org.neo4j.graphdb.Node;
import playerInfo.Player;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ConsolePane extends JPanel {

    public List<Player> playerInfo;
    public List<Node> playerNode;
    public List<Agents> playerAgent;
    private static JPanel contentPane = new JPanel();
    private static JPanel north = new JPanel();
    private static JPanel south = new JPanel();
    private static Hannah hannah;

    public ConsolePane(Hannah hannah) {
        this.hannah = hannah;
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

    public void displayNorth() {
        north.add(hannah.getState().onNorth());
        contentPane.add(new JScrollPane(north));
    }

    public void displaySouth() {
        south.add(hannah.getState().onSouth());
        contentPane.add(south);
    }

    public static JPanel getContentPane(){ return contentPane; }
    public static JPanel getNorthPane() { return north; }
    public static JPanel getSouthPane() { return south; }

}
