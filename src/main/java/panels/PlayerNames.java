package panels;

import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerNames implements State{

    protected List<String> playerName;
    protected List<Player> playerInfo = new ArrayList<>();
    protected LoadFileUtil fu = new LoadFileUtil();
    protected static String path = "/Users/hannimpeha/HANNIMPEHA/" +
            "Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";
    protected Student student;
    protected static JPanel north = new JPanel();
    protected static JPanel south = new JPanel();

    public PlayerNames(Student student) {
        this.student = student;
    }

    public JPanel createPanel(Student student) {
            final JTextArea textAreaOrder =
                    new JTextArea(20, 40);
            textAreaOrder.setText("Type Players's Names");
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
                    playerInfo = fu.setAllPlayers();
                    fu.saveGame(playerInfo);
                }
            });
            box.add(button);
            south.add(box);
        return south;
    }

    @Override
    public String getName() {
        return "Name";
    }
}