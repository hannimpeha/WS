package util;

import consoles.CommandListener;
import consoles.ConsolePane;
import playerInfo.Player;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LoadFileUtil {

    private CommandListener listener;
    private PrintWriter pw;
    private CreatePlayerUtil cpu;
    private List<Player> playerInfo;
    private List<String> playerName;
    private List<String> playerRole;

    private InputStream is;

    public LoadFileUtil() {
        this.listener = listener;
    }

    public void newFile() throws IOException {
        listener.commandOutput("Type players' names separated by Enter and \"end\"");
        pw = new PrintWriter("/Users/" +
                "hannimpeha/" +
                "HANNIMPEHA/Thesis/" +
                "FascinatingProject" +
                "/src/main/java/resource/" +
                "players.txt");
        //pw.println(cmd);
        pw.close();
            //System.out.println("You have typed " + playerName.size() + " " +
            //        "players in total. Assigned roles are as follows.");
            //createRoles(playerName);
            //setAllPlayers(playerName, playerRole);
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

    private void setAllPlayers(List<String> names, List<String> roles) {
        for(int i=0; i<names.size(); i++) {
            System.out.println(names.get(i)+" is "+roles.get(i)+".");
            playerInfo.add(CreatePlayerUtil.createPlayer(names.get(i), roles.get(i), i));
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
//        String file = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
//                "FascinatingProject" +
//                "/src/main/java/resource/saveGame.txt";
//        try {
//            br = new BufferedReader(new FileReader(new File(file)));
//            sb = new StringBuilder();
//            String str = br.readLine();
//            while (str != null) {
//                sb.append(str);
//                sb.append(System.lineSeparator());
//                str = br.readLine();
//            }
//            playerLine = sb.toString();
//            //System.out.println(sb.toString().split(","));
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
//        return playerLine;
    }

    public void saveGame() {
        //deletePlayers(makePlayer(loadFile()),lynched);
        //System.out.println(makePlayer(loadFile()).size());
    }

    private void makePlayer(String playerLine) {
//        String name = playerLine.split(",")[0];
//        String role = playerLine.split(",")[1];
//        int status = parseInt(playerLine.split(",")[2]);
//        boolean target = parseBoolean(playerLine.split(",")[3]);
//        switch(role) {
//            case "Mafia":
//                playerInfo.add(cpu.createPlayer(
//                        name, "Mafia",0, status, target));
//            case "Townie":
//                playerInfo.add(cpu.createPlayer(
//                        name, "Townie", 1, status, target));
//            case "Doctor":
//                playerInfo.add(cpu.createPlayer(
//                        name, "Doctor", 2, status, target));
//        }
//        return playerInfo;
    }

    public List<Player> getPlayerInfo() {
        List<Player> clone = new ArrayList<>(playerInfo);
        playerInfo = new ArrayList<>();
        return clone;
    }
}
