package panels;

import jason.NCT;
import jason.infra.centralised.RunCentralisedMAS;
import thatGraph.GraphVizExe;
import ballot.Voting;
import playerInfo.Player;
import util.LoadFileUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DayPanel implements State {

    protected LoadFileUtil fu;
    protected Voting vote;
    protected String victim;
    protected String path = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
            "FascinatingProject/src/main/java/resource/awesome.dot";
    protected String namePath = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
            "FascinatingProject/src/main/java/resource/players.txt";
    protected String imagePath = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
            "FascinatingProject/src/main/java/resource/simple.png";
    protected GraphVizExe gv = new GraphVizExe();
    protected Student student;
    private static JPanel north = new JPanel();
    private static JPanel realNorth = new JPanel();
    private static JPanel south = new JPanel();
    private List<Player> playerInfo;
    private List<String> playerName;
    private BufferedImage myPicture;


    public DayPanel(Student student) {
        this.student = student;
        vote = new Voting(student);
        victim = vote.run();
        playerInfo = getPlayerInfo(student);
        playerName = getPlayerName(student);
    }

    public JPanel createPanel(Student student) {
        final JTextArea textAreaOrder =
                new JTextArea(20, 40);
        textAreaOrder.setText("\n" +
                "     ____                    \n" +
                "    |  _   \\   __ _   _    _ \n" +
                "    | |  |  | / _` | | |  | |\n" +
                "    | |_|  | | (_|  | | |_| |\n" +
                "    |____/ \\__,_| \\__, |\n" +
                "                          |___/ \n" +
                "\n");
        textAreaOrder.append("  - There was [ "+playerName.size()+" ] number of players.\n");
        textAreaOrder.append("    * Mafia : "+playerInfo.stream().filter(
                a->a.getRole().contains("Mafia")).collect(Collectors.toList()).size()+"\n"+
                "    * Townie : "+playerInfo.stream().filter(
                        a->a.getRole().contains("Townie")).collect(Collectors.toList()).size()+"\n"+
                "    * Doctor : "+playerInfo.stream().filter(
                        a->a.getRole().contains("Doctor")).collect(Collectors.toList()).size()+"\n\n");
        textAreaOrder.append("  - By majority vote, player [ "+victim+" ] has been lynched.\n\n");
        gv.readSource(path);
        textAreaOrder.append("  - Their relationship was\n"+"     "+gv.getDotSource());
        textAreaOrder.setEditable(false);
        try {
            myPicture = ImageIO.read(new File(imagePath));
            JLabel picLabel = new JLabel(new ImageIcon(
                    myPicture.getScaledInstance(
                            200, 300, Image.SCALE_FAST)));
            realNorth.add(picLabel, BorderLayout.SOUTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        north.add(new JScrollPane(textAreaOrder));
        north.add(realNorth);
        return north;
    }

    public JPanel createButton(Student student) {
        final Box box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(
                5, 5, 5, 5));
        box.add(box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        final JButton button = new JButton("Day");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RunCentralisedMAS();
                new NCT(playerInfo);
                playerInfo.stream()
                        .filter(a->a.getName().contains(victim))
                        .forEach(a->a.setStatus(0));
                fu.saveGame(playerInfo);
                playerName = playerInfo.stream()
                        .filter(a->a.getStatus()==1)
                        .map(a->a.getName())
                        .collect(Collectors.toList());
                try {
                    Files.write(Paths.get(namePath), playerName);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        box.add(button);
        south.add(box);
        return south;
    }

    @Override
    public List<Player> getPlayerInfo(Student student) {
        fu = new LoadFileUtil();
        return fu.loadPlayer();
    }

    @Override
    public List<String> getPlayerName(Student student) {
        fu = new LoadFileUtil();
        return fu.loadFile();
    }

    @Override
    public String getName() {
        return "Day";
    }
}