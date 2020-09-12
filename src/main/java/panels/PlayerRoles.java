package panels;

import controllers.ActionListener;
import org.neo4j.graphdb.Node;
import playerInfo.Player;
import util.CreatePlayerUtil;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.List;

public class PlayerRoles  {

    private List<String> playerName;
    private List<String> playerRole;
    private List<Player> playerInfo = new ArrayList<>();
    private List<Node> playerNode = new ArrayList<>();
    private static final String saveFile =
            "/Users/hannimpeha/HANNIMPEHA/" +
                    "Thesis/FascinatingProject" +
                    "/src/main/java/resource/saveGame.txt";

    public PlayerRoles() {
        createPanel();
        setAllPlayers();
        setAllNodes();
        saveGame(playerInfo);
    }


    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 30);
        playerName = Arrays.asList("hyo", "ji", "yoo",
                "mi", "vi", "se", "ari");
        createRoles(playerName);
        textAreaOrder.setText("Assigned Roles are as follows\n");
        for(int i=0; i<playerName.size(); i++) {
            textAreaOrder.append(playerName.get(i)+" is "+playerRole.get(i)+".\n");
        }
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }

    public void createRoles(List<String> playerName) {
        playerRole = Arrays.asList("Mafia", "Mafia", "Doctor",
                "Townie", "Townie", "Townie", "Townie");
        int num = playerName.size();
        switch(num) {
            case 3:
                playerRole = Arrays.asList("Mafia", "Doctor", "Townie");
            case 4:
                playerRole = Arrays.asList("Mafia", "Doctor", "Townie", "Townie");
            case 5:
                playerRole = Arrays.asList("Mafia", "Doctor", "Townie", "Townie", "Townie");
            case 6:
                playerRole = Arrays.asList("Mafia", "Mafia", "Doctor", "Townie", "Townie", "Townie");
            case 7:
                playerRole = Arrays.asList("Mafia", "Mafia", "Doctor", "Townie", "Townie", "Townie", "Townie");
        }
        Collections.shuffle(playerRole);
    }

    public List<Player> setAllPlayers() {
        for (int i = 0; i < playerName.size(); i++) {
            playerInfo.add(CreatePlayerUtil.createPlayer(
                    playerName.get(i), playerRole.get(i), i));
        }
        return playerInfo;
    }

    public List<Node> setAllNodes(){
        for (int i = 0; i < playerName.size(); i++) {
            playerNode.add(CreatePlayerUtil.createPlayer(
                    playerName.get(i), playerRole.get(i), i));
        }
        return playerNode;
    }

    public static void saveGame(List<Player> playerInfo) {
        try(PrintWriter pw = new PrintWriter(saveFile)) {
            for (Player p : playerInfo) {
                pw.print(p.getStatus());
                pw.print(p.getRole());
                pw.print(p.getName());
                pw.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

