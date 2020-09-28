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
    public PlayerNames pnp = new PlayerNames(student);
    public PlayerRoles prp = new PlayerRoles(student);
    public DayPanel dp = new DayPanel(student);
    public NightPanel np = new NightPanel(student);
    private JPanel contentPane = new JPanel();
    private JPanel north = new JPanel();
    private JPanel south = new JPanel();
    private JPanel realSouth = new JPanel();
    private static JScrollPane north1 = new JScrollPane();
    private static JScrollPane north2 = new JScrollPane();
    private static JScrollPane north3 = new JScrollPane();
    private static JScrollPane north4 = new JScrollPane();
    private static JPanel south1 = new JPanel();
    private static JPanel south2 = new JPanel();
    private static JPanel south3 = new JPanel();
    private static JPanel south4 = new JPanel();
    private JFrame frame = new JFrame("Hannah's Mafia Game");
    private List<String> playerName;
    private static String path = "/Users/hannimpeha/HANNIMPEHA/" +
            "Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";


    public ConsolePane() {
        displayNorth();
        displaySouth();
    }

    public void initFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 20, 400, 450);
        frame.setLocationRelativeTo(null);
        frame.add(north, BorderLayout.CENTER);
        frame.add(south, BorderLayout.PAGE_END);
        frame.pack();
        frame.setVisible(true);
    }

    private void displayNorth() {
        north.setLayout(new RXCardLayout(20, 20));
        north1 = new JScrollPane(pnp.createPanel(student));
        north2 = new JScrollPane(prp.createPanel(student));
        north3 = new JScrollPane(dp.createPanel(student));
        north4 = new JScrollPane(np.createPanel(student));
        north.add(north1, "Name");
        north.add(north2, "Role");
        north.add(north3, "Day");
        north.add(north4, "Night");
        contentPane.add(north);
    }

    private void displaySouth() {
        realSouth.setLayout(new RXCardLayout(20,20));
        final Box box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(
                5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        JButton button = new JButton("Enter");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                student.setState(student.nextTrack());
                RXCardLayout cardLayout = (RXCardLayout) north.getLayout();
                RXCardLayout layoutCard = (RXCardLayout) realSouth.getLayout();
                cardLayout.show(north, student.getState().getName());
                layoutCard.show(realSouth, student.getState().getName());
            }
        });
        south1 = pnp.createButton(student);
        south2 = prp.createButton(student);
        south3 = dp.createButton(student);
        south4 = np.createButton(student);

        realSouth.add(south1, "Name");
        realSouth.add(south2, "Role");
        realSouth.add(south3, "Day");
        realSouth.add(south4, "Night");

        box.add(realSouth);
        box.add(button);
        south.add(box);
        contentPane.add(south);
    }
}