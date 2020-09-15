package logic;

import playerInfo.Player;
import util.LoadFileUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NightAction {

    private Random randomGenerator;
    private List<String> playerName =
            Arrays.asList("ji", "yoo", "mi", "vi", "se", "ari");
    private LoadFileUtil fu = new LoadFileUtil(playerName);
    private List<Player> playerInfo = fu.setAllPlayers();
    public NightAction(){
    }

    public String nightAction() {
        randomGenerator = new Random();
        int ind = randomGenerator.nextInt(playerName.size()-1);
        return playerInfo.get(ind).getName();
    }
}
