package controllers;

import ballot.Voting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public abstract class ConsolePane extends JPanel {

    private List<String> playerName;
    private List<String> playerRole;
    protected JTextArea textAreaOrder;
    protected static JPanel contentPane = new JPanel();
    protected static JPanel north = new JPanel();
    protected static JPanel south = new JPanel();
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

    public void createFrame(){
        JFrame frame = new JFrame("Hannah's Mafia Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.pack();
        frame.setBounds(500, 20, 400, 430);
        frame.add(contentPane);
    }
    private void displayNorth(){
        north.setLayout(new CardLayout(20, 20));
        playerNames();
        playerRoles();
        dayStart();
        nightStart();
        victory();
        contentPane.add(north);
    }

    private void playerNames() {
        textAreaOrder = new JTextArea(20, 30);
        textAreaOrder.setText("Type Players's Names\n");
        textAreaOrder.setEditable(false);
        north.add(new JScrollPane(textAreaOrder));
    }

    private void playerRoles() {
        playerName = Arrays.asList("hyo", "ji", "yoo",
                "mi", "vi", "se", "ari");
        textAreaOrder = new JTextArea(20, 30);
        createRoles(playerName);
        textAreaOrder.setText("Assigned Roles are as follows\n");
        for(int i=0; i<playerName.size(); i++) {
            textAreaOrder.append(playerName.get(i)+" is "+playerRole.get(i)+".\n");
        }
        textAreaOrder.setEditable(false);
        north.add(new JScrollPane(textAreaOrder));
    }

    public void createRoles(List<String> playerName) {
        playerRole = Arrays.asList("Mafia", "Mafia", "Doctor",
                "Townie", "Townie", "Townie", "Townie");
        int num = playerName.size();
        switch(num) {
            case 3:
                playerRole = Arrays.asList("Mafia", "Doctor", "Townie");
            case 4:
                playerRole = Arrays.asList("Mafia", "Doctor", "Townie", "Townie");
            case 5:
                playerRole = Arrays.asList("Mafia", "Doctor", "Townie", "Townie", "Townie");
            case 6:
                playerRole = Arrays.asList("Mafia", "Mafia", "Doctor", "Townie", "Townie", "Townie");
            case 7:
                playerRole = Arrays.asList("Mafia", "Mafia", "Doctor", "Townie", "Townie", "Townie", "Townie");
        }
        Collections.shuffle(playerRole);
    }

    private void dayStart() {
        Voting vote = new Voting();
        textAreaOrder = new JTextArea(20, 30);
        textAreaOrder.setText("Player "+vote.run()+" has been lynched");
        textAreaOrder.setEditable(false);
        north.add(new JScrollPane(textAreaOrder));
    }

    private void nightStart() {
        textAreaOrder = new JTextArea(20, 30);
        textAreaOrder.setText("Night Start");
        textAreaOrder.setEditable(false);
        north.add(new JScrollPane(textAreaOrder));
    }

    private void victory() {
        textAreaOrder = new JTextArea(20, 30);
        textAreaOrder.setText("Victory");
        textAreaOrder.setEditable(false);
        north.add(new JScrollPane(textAreaOrder));
    }

    private void displaySouth() {
        final Box box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        final JTextField textField = new JTextField(24);
        box.add(textField);
        JButton button = new JButton("Enter");
        button.addActionListener(new ActionListener() {
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

        final JButton dayButton = new JButton("Day");
        dayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) north.getLayout();
                cardLayout.previous(north);
            }
        });

        box.add(button);
        box.add(dayButton);
        south.add(box);
        contentPane.add(south);
    }

    public static JPanel getContentPane(){ return contentPane; }
    public static JPanel getNorthPane() { return north; }
    public static JPanel getSouthPane() { return south; }
}