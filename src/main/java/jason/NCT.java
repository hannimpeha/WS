package jason;

import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;
import playerInfo.Player;

import java.util.*;
import java.util.stream.Collectors;

public class NCT {

    private InternalAction ia;
    private TransitionSystem ts;
    private Unifier un;
    private Term[] args;

    public NCT(List<Player> playerInfo) {
        ia = new InternalAction(playerInfo);
        ia.execute(ts, un, args);
    }

}