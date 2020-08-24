package util;

import playerInfo.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LoadFileUtil {

    private List<Player> playerInfo = new ArrayList<>();
    private final String saveName = "src/resources/saveGame.txt";

    public LoadFileUtil() {
    }

    public void newFile(List<String> names, List<String> roles) {
        Collections.shuffle(roles);
        setAllPlayers(names, roles);
        try {
            SaveFileUtil.saveGame(playerInfo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadFile() {
        playerInfo = new ArrayList<>();
        int position = 0;
        List<String> line;
        try {
            Scanner fileScanner = new Scanner(new File(saveName));
            while (fileScanner.hasNextLine()) {
                String currentLine = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(currentLine);
                line = new ArrayList<>();
                while (lineScanner.hasNext()) {
                    line.add(lineScanner.next());
                }
                lineScanner.close();
                position = scanLine(line, position);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            try {
                loadException();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
    }

    private void loadException() throws FileNotFoundException {
        List<String> names = new ArrayList<>(Arrays.asList("Hannah","Ung","MunSik"));
        List<String> roles = new ArrayList<>(Arrays.asList("Mafia", "Townie", "Doctor"));
        newFile(names, roles);
    }


    private int scanLine(List<String> line, int positionID) {
        int status = Integer.parseInt(line.get(0));
        boolean lynched = Boolean.valueOf(line.get(1));
        String role = line.get(2);
        String name;
        if(role.contains("Mafia")) {
            name = getName(line, 4);
        } else {
            name = getName(line, 3);
        }
        playerInfo.add(CreatePlayerUtil.createPlayer(name, role, positionID, status, lynched));
        return positionID++;
    }

    private String getName(List<String> line, int place){
        String name="";
        for(int i=place;i<line.size();i++){
            name+=line.get(i)+" ";
        }
        name=name.substring(0, name.length()-1);
        return name;
    }

    private void setAllPlayers(List<String> names, List<String> roles) {
        for(int i=0; i<roles.size(); i++) {
            playerInfo.add(CreatePlayerUtil.createPlayer(names.get(i), roles.get(i), i));
        }
    }

    private int setLynchTarget(List<String> roles) {
        Random r = new Random();
        int target = r.nextInt(roles.size());
        return target;
    }

    public List<Player> getPlayerInfo() {
        List<Player> clone = new ArrayList<>(playerInfo);
        playerInfo = new ArrayList<>();
        return clone;
    }
}
