package jason;

import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;
import playerInfo.Player;
import util.LoadFileUtil;

import java.util.*;
import java.util.stream.Collectors;

public class NCT {

    private LoadFileUtil fu;
    private InternalAction ia;
    private TransitionSystem ts;
    private Unifier un;
    private Term[] args;

    public NCT(List<Player> playerInfo) {
        ia = new InternalAction(createAgent(playerInfo));
        ia.execute(ts, un, args);
        fu = new LoadFileUtil(getAgentName(playerInfo));
        fu.saveGame(playerInfo);
    }

    private List<Agents> createAgent(List<Player> playerInfo){
        return playerInfo.stream()
                .map(a->new Agents(a.getName(), a.getRole(), a.getStatus()))
                .collect(Collectors.toList());
    }

    private List<String> getAgentName(List<Player> playerInfo) {
        return playerInfo.stream()
                .map(a->a.getName())
                .collect(Collectors.toList());
    }


}