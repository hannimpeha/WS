package panels;

import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class PlayerNames implements State{

    protected LoadFileUtil fu;
    private static Student student = new Student();
    protected List<String> playerName;
    protected List<Player> playerInfo;
    protected static String path = "/Users/hannimpeha/HANNIMPEHA/" +
            "Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";
    protected static JPanel north = new JPanel();
    protected static JPanel south = new JPanel();

    public PlayerNames(Student student) {
        this.student = student;
    }

    public JPanel createPanel(Student student) {
            final JTextArea textAreaOrder =
                    new JTextArea(20, 40);
            textAreaOrder.setText("\n" +
                    "    ************************************************************************\n"+
                    "    **      __     __             __    _                ____                                       **\n" +
                    "    **     |   \\ /   |   __ _   / _| (_)   __ _     / ___|  __ _  _ __ __    ___        **\n" +
                    "    **     |  |\\ /|  | / _` | | |_  | |  / _` |   | |  _   / _` | | '_ ` _ \\ / _ \\       **\n" +
                    "    **     |  |    |  | | (_|  | |  _| | | | (_|  |   | |_| | | (_|  | | | | | | | |  __/       **\n" +
                    "    **     |_|     |_| \\__,_| |_|   |_| \\__,_|   \\____| \\__,_||_||_||_|\\___|       **\n" +
                    "    **                                                                                                       **\n" +
                    "    *************************************************************************\n"+
                    "\n");

            textAreaOrder.append("    Type Players' Names.\n\n");
            textAreaOrder.append("    Name should be separated by commas.");
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
            final JTextField textField = new JTextField(24);
            box.add(textField);
            final JButton button = new JButton("Name");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playerName = Arrays.asList(
                            new JTextField(30)
                                    .getText().split(", "));
                    try {
                        Files.write(Paths.get(path), playerName);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    fu = new LoadFileUtil();
                    playerInfo = fu.setAllPlayers();
                    fu.saveGame(playerInfo);
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
        return "Name";
    }
}