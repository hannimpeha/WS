package panels;

import logic.NightAction;
import logic.Victory;
import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class NightPanel implements State {

    protected LoadFileUtil fu = new LoadFileUtil();;
    protected NightAction na = new NightAction();
    protected String victim = na.nightAction();
    protected List<Player> playerInfo = fu.loadPlayer()
            .stream().filter(a->a.getStatus()==1).collect(Collectors.toList());
    protected Victory victory = new Victory(playerInfo);
    protected Student student;
    private static JPanel north = new JPanel();
    private static JPanel south = new JPanel();
    private List<String> playerName = fu.loadFile();
    protected String namePath = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
            "FascinatingProject/src/main/java/resource/players.txt";

    public NightPanel(Student student) {
        this.student = student;
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
            textAreaOrder.append("  "+victory.victoryMessage());
            textAreaOrder.setEditable(false);
            north.add(new JScrollPane(textAreaOrder));
        return north;
    }

    public JPanel createButton(Student student) {
            final Box box = Box.createHorizontalBox();
            box.setBorder(BorderFactory.createEmptyBorder(
                    5, 5, 5, 5));
            box.add(Box.createHorizontalStrut(5));
            box.add(Box.createHorizontalGlue());
            final JButton button = new JButton("Night");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
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
    public String getName() {
        return "Night";
    }
}