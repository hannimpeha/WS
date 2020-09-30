package panels;

import logic.NightAction;
import logic.Victory;
import playerInfo.Player;
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
    protected NightAction na = new NightAction();
    protected String victim = na.nightAction();
    protected Student student;
    private static JPanel north = new JPanel();
    private static JPanel realNorth = new JPanel();
    private static JPanel south = new JPanel();
    private List<Player> playerInfo;
    private List<String> playerName;
    protected String namePath = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
            "FascinatingProject/src/main/java/resource/players.txt";
    protected String imagePath = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
            "FascinatingProject/src/main/java/resource/simple.png";
    private BufferedImage myPicture;

    public NightPanel(Student student) {
        this.student = student;
        playerInfo = student.getPlayerInfo();
        playerName = student.getPlayerName();
    }

    public JPanel createPanel(Student student) {
            final JTextArea textAreaOrder =
                    new JTextArea(20, 40);
            textAreaOrder.setText("\n" +
                "  _    _   _              _        _   \n" +
                " | \\ |  | (_)    __ _  | |__   | |_ \n" +
                " |  \\|  | |  |  / _` | | '_  \\ | __|\n" +
                " |  |\\  | |  | | (_|  | | | |  | | |_ \n" +
                " |_| \\_| |_|  \\__, | |_||_|  \\__|\n" +
                "                  |___/               \n" +
                "                                  \n" );
            textAreaOrder.append("  There are " + playerName.size()+" number of Players.\n\n");
            textAreaOrder.append("  "+victim + " has been chosen by Mafias.\n\n");
            Victory victory = new Victory();
            textAreaOrder.append("  "+victory.victoryMessage());
            try {
                myPicture = ImageIO.read(new File(imagePath));
                JLabel picLabel = new JLabel(new ImageIcon(
                    myPicture.getScaledInstance(200, 300, Image.SCALE_FAST)));
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
                List<Player> playerInfo = getPlayerInfo(student)
                        .stream().filter(a->a.getStatus()==1).collect(Collectors.toList());
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
    public String getName() {
        return "Night";
    }
}