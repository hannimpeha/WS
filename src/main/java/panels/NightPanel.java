package panels;

import jason.Agents;
import jason.NCT;
import jason.infra.centralised.RunCentralisedMAS;
import logic.NightAction;
import logic.Victory;
import playerInfo.Player;
import thatGraph.GraphVizExe;
import util.LoadFileUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class NightPanel implements State {

    protected LoadFileUtil fu;
    protected Student student;
    protected NightAction na;
    protected String victim;
    protected Victory victory;
    private static JPanel north = new JPanel();
    private static JPanel realNorth = new JPanel();
    private static JPanel south = new JPanel();
    private List<Player> playerInfo;
    private List<String> playerName;
    private List<Agents> playerAgent;
    protected String path = "/Users/hannahlee/HANNIMPEHA/Thesis/" +
            "FascinatingProject/src/main/java/resource/awesome.dot";
    protected String namePath = "/Users/hannahlee/HANNIMPEHA/Thesis/" +
            "FascinatingProject/src/main/java/resource/players.txt";
    protected String imagePath = "/Users/hannahlee/HANNIMPEHA/Thesis/" +
            "FascinatingProject/src/main/java/resource/simple.png";
    protected GraphVizExe gv = new GraphVizExe();
    private BufferedImage myPicture;

    public NightPanel(Student student) {
        this.student = student;
        na = new NightAction(student);
        victim = na.nightAction();
        victory = new Victory(student);
        playerInfo = getPlayerInfo(student);
        playerName = getPlayerName(student);
        playerAgent = getPlayerAgent(student);
    }

    public JPanel createPanel(Student student) {
        final JTextArea textAreaOrder =
                new JTextArea(20, 40);
        textAreaOrder.setText("\n" +
                "     _    _   _              _        _   \n" +
                "    | \\ |  | (_)    __ _  | |__   | |_ \n" +
                "    |  \\|  | |  |  / _` | | '_  \\ | __|\n" +
                "    |  |\\  | |  | | (_|  | | | |  | | |_ \n" +
                "    |_| \\_| |_|  \\__, | |_||_|  \\__|\n" +
                "                     |___/               \n" +
                "\n" );
        textAreaOrder.append("  - Now there are [ " + playerName.size()+" ] survivors.\n");
        textAreaOrder.append("    * Number of Mafia : [ "+playerInfo.stream().filter(
                a->a.getRole().contains("Mafia")).collect(Collectors.toList()).size()+" ]\n"+
                "    * Number of Townie : [ "+playerInfo.stream().filter(
                a->a.getRole().contains("Townie")).collect(Collectors.toList()).size()+" ]\n"+
                "    * Number of Doctor : [ "+playerInfo.stream().filter(
                a->a.getRole().contains("Doctor")).collect(Collectors.toList()).size()+" ]\n\n");
        textAreaOrder.append("  - But, [ "+victim+" ] has been chosen by Mafia.\n\n");
        textAreaOrder.append("  - Result of the Day : [ "+victory.victoryMessage()+" ]\n\n");
        gv.readSource(path);
        textAreaOrder.append("  - The directed graph is\n"+gv.getDotSource());
        try {
            myPicture = ImageIO.read(new File(imagePath));
            JLabel picLabel = new JLabel(new ImageIcon(
                    myPicture.getScaledInstance(
                            200, 300, Image.SCALE_FAST)));
            realNorth.add(picLabel, BorderLayout.SOUTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        textAreaOrder.setEditable(false);
        north.add(new JScrollPane(textAreaOrder));
        north.add(realNorth);
        return north;
    }

    public JPanel createButton(Student student) {
        final Box box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(
                5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        final JButton button = new JButton("Night");
        button.addActionListener(e -> {
            new RunCentralisedMAS();
            new NCT(playerInfo, playerAgent);
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
    public List<Agents> getPlayerAgent(Student stduent) {
        fu = new LoadFileUtil();
        return fu.loadAgents();
    }

    @Override
    public String getName() {
        return "Night";
    }
}