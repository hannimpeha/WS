package controllers;

import jason.Agents;
import org.neo4j.graphdb.Node;
import panels.DayPanel;
import panels.NightPanel;
import panels.PlayerNames;
import panels.PlayerRoles;
import playerInfo.Player;
import stateMachine.Hannah;
import stateMachine.State;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ConsolePane extends JPanel {

    private static Hannah hannah;
    public List<Player> playerInfo;
    public List<Node> playerNode;
    public List<Agents> playerAgent;

    private static JPanel contentPane = new JPanel();
    private static JPanel north = new JPanel();
    private static JPanel south = new JPanel();
    private static Box box = Box.createHorizontalBox();
    private static JButton button = new JButton("Enter");
    private static JTextField textField = new JTextField(24);


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
        button.addActionListener(e->
                north.add(new JScrollPane(switchPanel(hannah.getState()))));
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

    public JTextArea switchPanel(State state) {
        switch(state.getCurrent()) {
            case "Name" : return new PlayerNames(hannah).createPanel();
            case "Role" : return new PlayerRoles(hannah).createPanel();
            case "Day" : return new DayPanel(hannah).createPanel();
            case "Night" : return new NightPanel(hannah).createPanel();
            default : break;
        }
        return null;
    }

    public static JPanel getContentPane(){ return contentPane; }
    public static JPanel getNorthPane() { return north; }
    public static JPanel getSouthPane() { return south; }
    public static JTextField getTextField() { return textField; }
    public static Box getBox() { return box; }
    public static JButton getButton() { return button; }

}
