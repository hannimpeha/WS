package jason;

import playerInfo.Player;

import java.util.*;
import java.util.stream.Stream;

public class NCT {

    public NCT(List<Player> playerInfo) {
        createAgent(playerInfo).forEach(Agent::run);
    }

    private Stream<Agent> createAgent(List<Player> playerInfo){
        return playerInfo.stream()
                .map(a->new Agent(a.getName(), a.getRole(), a.getStatus()));
    }


}
