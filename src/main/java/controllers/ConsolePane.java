package controllers;

import jason.Agents;
import org.neo4j.graphdb.Node;
import playerInfo.Player;
import stateMachine.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class ConsolePane extends JPanel {


    public List<Player> playerInfo;
    public List<Node> playerNode;
    public List<Agents> playerAgent;

    private static Hannah hannah;
    private static JPanel contentPane = new JPanel();
    private static JPanel north = new JPanel();
    private static JPanel south = new JPanel();
    private static Box box = Box.createHorizontalBox();
    private static JTextField textField = new JTextField(24);

    public ConsolePane(Hannah hannah) {
        displayNorth(hannah);
        displaySouth(hannah);
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

    public void displayNorth(Hannah hannah) {
        north.add(new JScrollPane(hannah.getState().onNextTop()));
        contentPane.add(north);
    }

    public void displaySouth(Hannah hannah) {
        box.setBorder(
                BorderFactory.createEmptyBorder(5, 1, 5, 1));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        box.add(textField);
        box.add(hannah.getState().onNextBottom());
        south.add(box);
        contentPane.add(south);
    }

    public static JPanel getContentPane(){ return contentPane; }
    public static JPanel getNorthPane() { return north; }
    public static JPanel getSouthPane() { return south; }
    public static JTextField getTextField() { return textField; }
    public static Box getBox() { return box; }

}
