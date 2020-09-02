package panels;

import consoles.StreamWriter;
import controllers.ConsolePane;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class PlayerRolePanel extends ConsolePane {

    private ActionListener listener;
    private List<String> playerNames = Arrays.asList("HyoJung", "JiHyo", "YooA",
            "MiMi", "Vinie", "SeungHee", "Arin");
    private List<String> playerRoles = Arrays.asList("Mafia", "Mafia", "Doctor",
            "Townie", "Townie", "Townie", "Townie");
    private JButton btnRoles;
    private String path = "/Users/hannimpeha/HANNIMPEHA/Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";

    public PlayerRolePanel(ActionListener listener) {
        this.listener = listener;
        initialize();
    }

    private void initialize() {
        btnRoles = new JButton("Enter");
        displayNorth();
        displaySouth();
    }

    private void displayNorth() {
        try {
            playerNames = Files.readAllLines(Paths.get(path));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        playerRoles = createRoles(playerNames);
        textAreaOrder = new JTextArea(20, 30);
        textAreaOrder.setText("Roles were assigned");
        textAreaOrder.setEditable(false);
        try {
            OutputStream os = new StreamWriter(textAreaOrder);
            System.setOut(new PrintStream(os, true, "UTF-8"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        north.add(new JScrollPane(textAreaOrder));
    }

    private void displaySouth() {
        box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        textField = new JTextField(24);
        box.add(textField);
        btnRoles.addActionListener(listener);
        btnRoles.setName("Game_Start");
        box.add(btnRoles);
        south.add(box);
    }

    public List<String> createRoles(List<String> playerName) {
        int num = playerName.size();
        switch(num) {
            case 3:
                playerRoles = Arrays.asList("Mafia", "Doctor", "Townie");
            case 4:
                playerRoles = Arrays.asList("Mafia", "Doctor", "Townie", "Townie");
            case 5:
                playerRoles = Arrays.asList("Mafia", "Doctor", "Townie", "Townie", "Townie");
            case 6:
                playerRoles = Arrays.asList("Mafia", "Mafia", "Doctor", "Townie", "Townie", "Townie");
            case 7:
                playerRoles = Arrays.asList("Mafia", "Mafia", "Doctor", "Townie", "Townie", "Townie", "Townie");
        }
        //Collections.shuffle(playerRoles);
        return playerRoles;
    }

}