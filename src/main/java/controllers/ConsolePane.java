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

    private Student student;
    public List<Player> playerInfo;
    public List<Node> playerNode;
    public List<Agents> playerAgent;
    public PlayerNames pnp = new PlayerNames();
    public PlayerRoles prp = new PlayerRoles();
    public DayPanel dp = new DayPanel();
    public NightPanel np = new NightPanel();
    private static JPanel contentPane = new JPanel();
    private static JPanel north = new JPanel();
    private static JPanel south = new JPanel();
    private static JPanel realSouth = new JPanel();
    private static JScrollPane north1 = new JScrollPane();
    private static JScrollPane north2 = new JScrollPane();
    private static JScrollPane north3 = new JScrollPane();
    private static JScrollPane north4 = new JScrollPane();
    private static Box south1 = Box.createHorizontalBox();
    private static JButton south2 = new JButton();
    private static JButton south3 = new JButton();
    private static JButton south4 = new JButton();
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
        north.setLayout(new RXCardLayout(20, 20));
        north1 = new JScrollPane(pnp.createPanel());
        north2 = new JScrollPane(prp.createPanel());
        north3 = new JScrollPane(dp.createPanel());
        north4 = new JScrollPane(np.createPanel());
        north.add(north1, "north1");
        north.add(north2, "north2");
        north.add(north3, "north3");
        north.add(north4, "north4");
//        north1 = new JScrollPane(student.getState().onPlayAbove(student));
//        north.add(north1, "north1");
        //north2 = new JScrollPane(student.getState().onExitAbove(student));

        //north.add(north2, "north2");
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
                RXCardLayout layoutCard = (RXCardLayout) realSouth.getLayout();
                RXCardLayout cardLayout = (RXCardLayout) north.getLayout();
                cardLayout.next(north);
                layoutCard.next(realSouth);
            }
        });

        south1 = pnp.createButton();
        south2 = prp.createButton();
        south3 = dp.createButton();
        south4 = np.createButton();

//        JButton button = dp.createButton();
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println(e.getActionCommand());
//                if(e.getActionCommand()=="Day") {
//                    student.setState(new NightPanel(student));
//                } else {
//                    student.setState(new DayPanel(student));
//                }
//                south1 = student.getState().onPlayBottom(student);
//            }
//        });
        //south2 = student.getState().onExitBottom(student);
        south2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RXCardLayout cardLayout = (RXCardLayout) north.getLayout();
                cardLayout.show(north, "north2");
            }
        });

        south3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RXCardLayout cardLayout = (RXCardLayout) north.getLayout();
                cardLayout.show(north, "north3");
            }
        });

        south4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RXCardLayout cardLayout = (RXCardLayout) north.getLayout();
                cardLayout.show(north, "north4");
            }
        });

        realSouth.add(south1, "south1");
        realSouth.add(south2, "south2");
        realSouth.add(south3, "south3");
        realSouth.add(south4, "south4");

        box.add(realSouth);
        box.add(button);
        south.add(box);
        contentPane.add(south);
    }

    public static JPanel getContentPane(){ return contentPane; }
    public static JPanel getNorthPane() { return north; }
    public static JPanel getSouthPane() { return south; }
}