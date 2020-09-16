package controllers;

import jason.Agents;
import org.neo4j.graphdb.Node;
import playerInfo.Player;
import stateMachine.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class ConsolePane extends JPanel {

    private static Hannah hannah;
    public List<Player> playerInfo;
    public List<Node> playerNode;
    public List<Agents> playerAgent;

    private static JPanel contentPane = new JPanel();
    private static JPanel north = new JPanel();
    private static JPanel south = new JPanel();
    private static Box box = Box.createHorizontalBox();
    private static JButton button = new JButton("Enter");
    private static JTextArea textAreaOrder = new JTextArea(20, 30);
    private static JTextField textField = new JTextField(24);


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

    public void displayNorth() {
        north.add(new JScrollPane(new NameState(hannah).onName()));
        contentPane.add(north);
    }

    public void displaySouth() {
        box.setBorder(
                BorderFactory.createEmptyBorder(5, 1, 5, 1));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        box.add(textField);
        box.add(button);
        south.add(box);
        contentPane.add(south);
    }

    public static JPanel getContentPane(){ return contentPane; }
    public static JPanel getNorthPane() { return north; }
    public static JPanel getSouthPane() { return south; }
    public static JTextField getTextField() { return textField; }
    public static Box getBox() { return box; }
    public static JButton getButton() { return button; }
    public static JTextArea getTextAreaOrder() { return textAreaOrder; }

}
