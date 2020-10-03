package jason;

import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;
import playerInfo.Player;

import java.util.*;

public class NCT {

    private InternalAction ia;
    private TransitionSystem ts;
    private Unifier un;
    private Term[] args;
    private List<Player> playerInfo;
    private List<Agents> playerAgent;

    public NCT(List<Player> playerInfo, List<Agents> playerAgent) {
        this.playerInfo = playerInfo;
        this.playerAgent = playerAgent;
        ia = new InternalAction(playerInfo, playerAgent);
        ia.execute(ts, un, args);
    }

}