package panels;

import jason.NCT;
import jason.infra.centralised.RunCentralisedMAS;
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
import java.util.List;

public class PlayerRoles implements State{

    protected LoadFileUtil fu;
    protected Student student;
    protected List<Player> playerInfo;
    protected List<String> playerName;
    private static JPanel north = new JPanel();
    private static JPanel realNorth = new JPanel();
    private static JPanel south = new JPanel();
    private BufferedImage myPicture;
    protected String imagePath = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
            "FascinatingProject/src/main/java/resource/mafia.jpg";

    public PlayerRoles(Student student) {
        this.student = student;
        playerInfo = getPlayerInfo(student);
    }

    public JPanel createPanel(Student student) {
        final JTextArea textAreaOrder =
                new JTextArea(20, 40);
        textAreaOrder.setText("\n"+
                "    **************************************************************************\n" +
                "    - Doctor | Heal another player each night | Lynch members of Mafia\n" +
                "    - Townie | You have nothing to do at night | Lynch members of Mafia\n" +
                "    - Mafia | Kill a Townies each night | Make the majority of Mafia\n");
        textAreaOrder.append("    **************************************************************************\n\n");
        textAreaOrder.append("    Assigned Roles are as follows.\n\n");
        for (int i = 0; i < playerInfo.size(); i++) {
            textAreaOrder.append(
                    "    ("+(i+1)+")  Player [ " + playerInfo.get(i).getName() + " ] is [ " +
                            playerInfo.get(i).getRole() + " ].\n");
        }
        textAreaOrder.setEditable(false);
        try {
            myPicture = ImageIO.read(new File(imagePath));
            JLabel picLabel = new JLabel(new ImageIcon(
                    myPicture.getScaledInstance(
                            200, 300, Image.SCALE_FAST)));
            realNorth.add(picLabel, BorderLayout.SOUTH);
        }catch(IOException exception) {
            exception.printStackTrace();
        }
        north.add(new JScrollPane(textAreaOrder), BorderLayout.BEFORE_LINE_BEGINS);
        north.add(realNorth);
        return north;
    }

    public JPanel createButton(Student student) {
        final Box box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(
                5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        final JButton button = new JButton("Role");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RunCentralisedMAS();
                new NCT(playerInfo);
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
        return "Role";
    }
}
