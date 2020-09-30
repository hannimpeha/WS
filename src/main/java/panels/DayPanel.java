package panels;

import thatGraph.GraphVizExe;
import ballot.Voting;
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

public class DayPanel implements State {

    protected LoadFileUtil fu;
    protected Voting vote = new Voting();
    protected String victim = vote.run();
    protected String path = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
            "FascinatingProject/src/main/java/resource/awesome.dot";
    protected String namePath = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
            "FascinatingProject/src/main/java/resource/players.txt";
    protected GraphVizExe gv = new GraphVizExe();
    protected Student student;
    private static JPanel north = new JPanel();
    private static JPanel south = new JPanel();
    private List<Player> playerInfo;
    private List<String> playerName;


    public DayPanel(Student student) {
        this.student = student;
        playerInfo = student.getPlayerInfo();
        playerName = student.getPlayerName();
    }

    public JPanel createPanel(Student student) {
        final JTextArea textAreaOrder =
                new JTextArea(20, 40);
        textAreaOrder.setText("\n" +
                "  ____                    \n" +
                " |  _   \\   __ _   _    _ \n" +
                " | |  |  | / _` | | |  | |\n" +
                " | |_|  | | (_|  | | |_| |\n" +
                " |____/ \\__,_| \\__, |\n" +
                "                       |___/ \n" +
                "                        \n");
        textAreaOrder.append("  There are " + playerName.size() + " number of Players.\n\n");
        textAreaOrder.append("  Player " + victim + " has been lynched.\n\n");
        gv.readSource(path);
        textAreaOrder.append("  Their relationship was\n\n" + "  "+ gv.getDotSource()+".");
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
            final JButton button = new JButton("Day");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
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