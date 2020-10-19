package util;

import jason.Agents;
import org.neo4j.graphdb.Node;
import playerInfo.Player;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LoadFileUtil {

    private static SaveFileUtil su = new SaveFileUtil();
    private List<String> playerName = new ArrayList<>();
    private List<String> playerRole = new ArrayList<>();
    private List<Player> playerInfo = new ArrayList<>();
    private final List<Node> playerNode = new ArrayList<>();
    private final List<Agents> playerAgent = new ArrayList<>();
    private static final String path =
            "/Users/hannahlee/HANNIMPEHA/" +
            "Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";
    private static final String saveFile =
            "/Users/hannahlee/HANNIMPEHA/" +
                    "Thesis/FascinatingProject" +
                    "/src/main/java/resource/saveGame.txt";;

    public LoadFileUtil() {
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
            case 8:
                playerRole = Arrays.asList("Mafia", "Mafia", "Doctor", "Townie", "Townie", "Townie", "Townie", "Townie");
            case 9:
                playerRole = Arrays.asList("Mafia", "Mafia", "Mafia", "Doctor", "Townie", "Townie", "Townie", "Townie", "Townie");
            case 10:
                playerRole = Arrays.asList("Mafia", "Mafia", "Mafia", "Doctor", "Townie", "Townie", "Townie", "Townie", "Townie", "Townie");
            case 11:
                playerRole = Arrays.asList("Mafia", "Mafia", "Mafia", "Doctor", "Townie", "Townie", "Townie", "Townie", "Townie", "Townie", "Townie");
            case 12:
                playerRole = Arrays.asList("Mafia", "Mafia", "Mafia", "Doctor", "Townie", "Townie", "Townie", "Townie", "Townie", "Townie", "Townie", "Townie");
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
        for (int i = 0; i < playerInfo.size(); i++) {
            playerNode.add(CreatePlayerUtil.createPlayer(
                    playerName.get(i), playerRole.get(i), i));
        }
        return playerNode;
    }

    public List<Agents> setAllAgents(){
        for (int i = 0; i < playerInfo.size(); i++) {
            playerAgent.add(new Agents(
                    playerName.get(i), playerRole.get(i), 1));
        }
        return playerAgent;
    }


    public void saveGame(List<Player> playerInfo) {
        su.saveGame(playerInfo);
    }

    public List<String> loadFile() {
        try {
            playerName = Files.readAllLines(
                    Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return playerName;
    }

    public List<Player> loadPlayer() {
        try{
            List<String> playerAll = new ArrayList<>();
            playerAll = Files.readAllLines(
                    Paths.get(saveFile), StandardCharsets.UTF_8);
            for(int i=0; i<playerAll.size(); i++) {
                String str = playerAll.get(i);
                String[] arr = str.split(",");
                playerInfo.add(
                        CreatePlayerUtil.createPlayer(
                                arr[2], arr[1], Integer.parseInt(arr[0])));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return playerInfo;
    }

    public List<Agents> loadAgents() {
        try{
            List<String> playerAll = new ArrayList<>();
            playerAll = Files.readAllLines(
                    Paths.get(saveFile), StandardCharsets.UTF_8);
            for(int i=0; i<playerAll.size(); i++) {
                String str = playerAll.get(i);
                String[] arr = str.split(",");
                playerAgent.add(new Agents(arr[2], arr[1], Integer.parseInt(arr[0])));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return playerAgent;
    }

}