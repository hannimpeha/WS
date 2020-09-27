package controllers;

import jason.Agents;
import org.neo4j.graphdb.Node;
import panels.*;
import playerInfo.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ConsolePane extends JPanel {

    private static Student student = new Student();
    public List<Player> playerInfo;
    public List<Node> playerNode;
    public List<Agents> playerAgent;
    public PlayerNames pnp = new PlayerNames();
    public PlayerRoles prp = new PlayerRoles(student);
    public DayPanel dp = new DayPanel(student);
    public NightPanel np = new NightPanel(student);
    private static JPanel contentPane = new JPanel();
    private static JPanel north = student.getState().createPanel();
    private static JPanel south = student.getState().createButton();
    private List<String> playerName;
    private static String path = "/Users/hannimpeha/HANNIMPEHA/" +
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

    private void displayNorth() {
        contentPane.add(north);
    }

    private void displaySouth() {
        final Box box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(
                5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        JButton button = new JButton("Enter");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(student.getState().getName()) {
                    case "Name" : student.setState(new PlayerRoles(student));
                    case "Role" : student.setState(new DayPanel(student));
                    case "Day" : student.setState(new NightPanel(student));
                    case "Night" : student.setState(new DayPanel(student));
                }
            }
        });
        box.add(button);
        south.add(box);
        contentPane.add(south);
    }

    public static JPanel getContentPane(){ return contentPane; }
    public static JPanel getNorthPane() { return north; }
    public static JPanel getSouthPane() { return south; }
}