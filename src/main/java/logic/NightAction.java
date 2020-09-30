package logic;

import playerInfo.Player;
import util.LoadFileUtil;

import java.util.List;
import java.util.Random;

public class NightAction {

    private Random randomGenerator;
    private LoadFileUtil fu = new LoadFileUtil();
    private List<String> playerName = fu.loadFile();

    public NightAction(){
    }

    public String nightAction() {
        randomGenerator = new Random();
        int ind = randomGenerator.nextInt(playerName.size()-1);
        return playerName.get(ind);
    }
}
