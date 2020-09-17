package controllers;

import jason.Agents;
import org.bouncycastle.cert.ocsp.jcajce.JcaRespID;
import org.neo4j.graphdb.Node;
import panels.*;
import playerInfo.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ConsolePane extends JPanel {

    public List<Player> playerInfo;
    public List<Node> playerNode;
    public List<Agents> playerAgent;
    public SettingPanel sp = new SettingPanel();
    public PlayerNames pnp = new PlayerNames();
    public PlayerRoles prp = new PlayerRoles();
    public DayPanel dp = new DayPanel();
    public NightPanel np = new NightPanel();
    private static JPanel contentPane = new JPanel();
    private static JPanel north = new JPanel();
    private static JPanel south = new JPanel();
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

    private void displayNorth(){
        north.setLayout(new CardLayout(20, 20));
        north.add(new JScrollPane(sp.createPanel()), "north0");
        north.add(new JScrollPane(pnp.createPanel()), "north1");
        north.add(new JScrollPane(prp.createPanel()), "north2");
        north.add(new JScrollPane(dp.createPanel()), "north3");
        north.add(new JScrollPane(np.createPanel()), "north4");
        contentPane.add(north);
    }

    private void displaySouth() {
        final Box box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(5, 1, 5, 1));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        final JTextField textField = new JTextField(24);
        box.add(textField);
        JButton button = new JButton("Enter");
        south.setLayout(new CardLayout(20, 20));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerName = Arrays.asList(textField.getText().split(", "));
                try {
                    Files.write(Paths.get(path),playerName);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                CardLayout cardLayout = (CardLayout) north.getLayout();
                CardLayout layoutCard = (CardLayout) south.getLayout();

                cardLayout.next(north);
                layoutCard.next(south);
//                if(e.getActionCommand()=="Enter") {
//                    cardLayout.show(north, "north2");
//                    layoutCard.show(south, "south2");
//                } else if (e.getActionCommand()=="Name") {
//                    cardLayout.show(north, "north2");
//                    layoutCard.show(south, "south2");
//                } else if (e.getActionCommand()=="Role") {
//                    cardLayout.show(north, "north3");
//                    layoutCard.show(south, "south3");
//                } else if (e.getActionCommand()=="Day") {
//                    cardLayout.show(north, "north4");
//                    layoutCard.show(south, "south4");
//                } else if (e.getActionCommand()=="Night") {
//                    cardLayout.show(north, "north1");
//                    layoutCard.show(south, "south1");
//                } else {
//                    cardLayout.show(north, "north3");
//                    layoutCard.show(south, "south3");
//                }
            }
        });
        box.add(button);
        south.add(box, "south0");
        south.add(pnp.createButton(), "south1");
        south.add(prp.createButton(), "south2");
        south.add(dp.createButton(), "south3");
        south.add(np.createButton(), "south4");
        contentPane.add(south);
    }

    public static JPanel getContentPane(){ return contentPane; }
    public static JPanel getNorthPane() { return north; }
    public static JPanel getSouthPane() { return south; }
}