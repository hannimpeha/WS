package logic;

import playerInfo.*;
import util.LoadFileUtil;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private LoadFileUtil fu;
    private List<Player> playerInfo;
    private String lynched;

    public Game(List<Player> playerInfo, String lynched) {
        this.playerInfo = playerInfo;
        this.lynched = lynched;
        fu = new LoadFileUtil(getAgentName(playerInfo, lynched));
        fu.saveGame(remainingPlayer(playerInfo, lynched));
    }

    private List<String> getAgentName(List<Player> playerInfo, String lynched) {
        return playerInfo.stream()
                .map(a->a.getName())
                .filter(a->a.contains(lynched))
                .collect(Collectors.toList());
    }

    private List<Player> remainingPlayer(List<Player> playerInfo, String lynched) {
        return playerInfo.stream()
                .filter(a->a.getName()!=lynched)
                .collect(Collectors.toList());
    }

}
