package logic;

import playerInfo.Player;
import util.LoadFileUtil;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NightAction {

    private Random randomGenerator;
    private LoadFileUtil fu = new LoadFileUtil();
    private List<Player> playerInfo = fu.loadPlayer()
            .stream().filter(a->a.getStatus()==1).collect(Collectors.toList());

    public NightAction(){
    }

    public String nightAction() {
        randomGenerator = new Random();
        int ind = randomGenerator.nextInt(playerInfo.size()-1);
        return playerInfo.get(ind).getName();
    }
}
