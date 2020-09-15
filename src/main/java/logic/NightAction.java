package logic;

import playerInfo.Player;

import java.util.List;
import java.util.Random;

public class NightAction {

    private Random randomGenerator;
    private List<Player> playerInfo;

    public NightAction(List<Player> playerInfo){
        this.playerInfo = playerInfo;
    }

    public String nightAction() {
        randomGenerator = new Random();
        return playerInfo.get(randomGenerator.nextInt()).getName();
    }

}
