package util;

import playerInfo.Player;

import java.io.*;
import java.util.*;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class LoadFileUtil {

    private List<Player> playerInfo = new ArrayList<>();
    private String playerLine;
    private List<String> playerName = new ArrayList<>();
    private List<String> playerRole = new ArrayList<>();
    private PrintWriter pw;
    private BufferedReader br;
    private String str;
    private String lynched;
    private Scanner scanner;
    private Scanner tokenizer;
    private int status;
    private StringBuilder sb;
    private CreatePlayerUtil cpu;

    public LoadFileUtil() {
    }

    public void newFile() {
        System.out.println("Type players' names separated by Enter and \"end\".");
        scanner = new Scanner(System.in);
        try {
            do {
                str = scanner.nextLine();
                pw = new PrintWriter(
                        "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
                                "FascinatingProject" +
                                "/src/main/java/resource/players.txt");
                tokenizer = new Scanner(str);
                tokenizer.useDelimiter(",");
                while(tokenizer.hasNext()) {
                    playerName.add(tokenizer.next());
                }
            } while (!str.equalsIgnoreCase("end"));
            playerName.remove(playerName.size()-1);
            pw.print(playerName);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.close();
        System.out.println("You have typed " + playerName.size() + " players in total. Assigned roles are as follows.");
        createRoles(playerName);
        setAllPlayers(playerName, playerRole);
        System.out.println("Type \"day\" to continue.");
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
        this.status=0;
    }

    public String loadFile() {
        String file = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
                "FascinatingProject" +
                "/src/main/java/resource/saveGame.txt";
        try {
            br = new BufferedReader(new FileReader(new File(file)));
            sb = new StringBuilder();
            String str = br.readLine();
            while (str != null) {
                sb.append(str);
                sb.append(System.lineSeparator());
                str = br.readLine();
            }
            playerLine = sb.toString();
            //System.out.println(sb.toString().split(","));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return playerLine;
    }

    public void saveGame() {
        deletePlayers(makePlayer(loadFile()),lynched);
        System.out.println(makePlayer(loadFile()).size());
    }

    private List<Player> makePlayer(String playerLine) {
        String name = playerLine.split(",")[0];
        String role = playerLine.split(",")[1];
        int status = parseInt(playerLine.split(",")[2]);
        boolean target = parseBoolean(playerLine.split(",")[3]);
        switch(role) {
            case "Mafia":
                playerInfo.add(cpu.createPlayer(
                        name, "Mafia",0, status, target));
            case "Townie":
                playerInfo.add(cpu.createPlayer(
                        name, "Townie", 1, status, target));
            case "Doctor":
                playerInfo.add(cpu.createPlayer(
                        name, "Doctor", 2, status, target));
        }
        return playerInfo;
    }

    public List<Player> getPlayerInfo() {
        List<Player> clone = new ArrayList<>(playerInfo);
        playerInfo = new ArrayList<>();
        return clone;
    }
}
