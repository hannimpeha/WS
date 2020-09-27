package logic;

import playerInfo.*;
import util.LoadFileUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private LoadFileUtil fu = new LoadFileUtil();
    private List<Player> playerInfo;
    private String lynched;
    private static String path = "/Users/hannimpeha/HANNIMPEHA/" +
            "Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";

    public Game(List<Player> playerInfo, String lynched) {
        try {
            Files.write(Paths.get(path), getAgentName(playerInfo, lynched));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> getAgentName(List<Player> playerInfo, String lynched) {
        return playerInfo.stream()
                .map(a -> a.getName())
                .filter(a -> a.contains(lynched))
                .collect(Collectors.toList());
    }



}