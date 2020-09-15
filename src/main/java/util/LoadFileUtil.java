package util;

import jason.Agents;
import org.neo4j.graphdb.Node;
import playerInfo.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LoadFileUtil {

    private static SaveFileUtil su;
    private CreatePlayerUtil cpu;
    private List<String> playerRole = new ArrayList<>();
    private List<Player> playerInfo = new ArrayList<>();
    private List<String> playerName = new ArrayList<>();
    private List<Node> playerNode = new ArrayList<>();
    private List<Agents> playerAgent = new ArrayList<>();
    private String path = "/Users/hannimpeha/HANNIMPEHA/" +
            "Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";

    public LoadFileUtil(List<String> playerName) {
        this.playerName = playerName;
        playerRole = createRoles(playerName);
        playerInfo = setAllPlayers();
        playerNode = setAllNodes();
        playerAgent = setAllAgents();
    }
    public void newFile(List<Player> playerInfo, String lynched) {
        deletePlayers(playerInfo, lynched);
        saveGame(playerInfo);
    }

    public List<String> createRoles(List<String> playerName) {
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
        return playerRole;
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

    public List<Agents> setAllAgents(){
        for (int i = 0; i < playerName.size(); i++) {
            playerAgent.add(new Agents(
                    playerName.get(i), playerRole.get(i), i));
        }
        return playerAgent;
    }

    public static void saveGame(List<Player> playerInfo) {
        su.saveGame(playerInfo);
    }

    public void deletePlayers(List<Player> playerInfo, String lynched) {
        for(Player p:playerInfo) {
            if(p.getName()==lynched) {
                p.setStatus(0);
            }
        }
    }

    public List<String> loadFile() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(new File(path)));
            StringBuilder sb = new StringBuilder();
            String str = br.readLine();
            while (str != null) {
                sb.append(str);
                sb.append(System.lineSeparator());
                str = br.readLine();
            }
            playerName.add(sb.toString());
            //System.out.println(sb.toString().split(","));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return playerName;
    }

    public ArrayList<Player> getPlayerInfo() {
        ArrayList<Player> clone = new ArrayList<>(playerInfo);
        playerInfo = new ArrayList<>();
        return clone;
    }
}
