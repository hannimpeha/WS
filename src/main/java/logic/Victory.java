package logic;

import playerInfo.Player;
import util.LoadFileUtil;

import java.util.List;
import java.util.stream.Collectors;

public class Victory {

    private List<Player> playerInfo;

    public Victory(List<Player> playerInfo) {
        this.playerInfo = playerInfo;
    }

    public String victoryMessage() {
        if(countingMafia(playerInfo)>=countingTownie(playerInfo)) {
            return "Mafia has won";
        } else {
            return "Townies still have some time";
        }
    }

    public int countingMafia(List<Player> playerInfo) {
        return playerInfo.stream()
                .map(a->a.getRole())
                .filter(a->a.contains("Mafia"))
                .collect(Collectors.toList()).size();
    }

    public int countingTownie(List<Player> playerInfo) {
        return playerInfo.stream()
                .map(a->a.getRole())
                .filter(a->!a.contains("Mafia"))
                .collect(Collectors.toList()).size();
    }
}
