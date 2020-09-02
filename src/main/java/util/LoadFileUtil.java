package util;

import playerInfo.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LoadFileUtil {

    private CreatePlayerUtil cpu;
    private List<Player> playerInfo;
    private List<String> playerName;
    private List<String> playerRole;
    private String path = "/Users/hannimpeha/HANNIMPEHA/" +
            "Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";

    public LoadFileUtil() {
    }

    public void newFile(List<String> playerName) {
        playerInfo = new ArrayList<>();
        createRoles(playerName);
        setAllPlayers();
        SaveFileUtil.saveGame(playerInfo);
    }

    public void createRoles(List<String> playerName) {
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

    private void setAllPlayers() {
        for(int i=0; i<playerName.size(); i++) {
            System.out.println("\n"+playerName.get(i)+" is "+playerRole.get(i)+".");
            playerInfo.add(CreatePlayerUtil.createPlayer(
                    playerName.get(i), playerRole.get(i), i));
        }
    }

    public void deletePlayers(List<Player> playerInfo, String lynched) {
        for(Player p:playerInfo) {
            if(p.getName()==lynched) {
                setLynchTarget();
            }
        }
    }

    private void setLynchTarget() {
        //this.status=0;
    }

    public void loadFile() {
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
    }

    public ArrayList<Player> getPlayerInfo() {
        ArrayList<Player> clone = new ArrayList<>(playerInfo);
        playerInfo = new ArrayList<>();
        return clone;
    }
}
