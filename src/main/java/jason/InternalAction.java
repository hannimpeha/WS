package jason;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

public class InternalAction extends DefaultInternalAction {

    private BaseBelief bb;

    public InternalAction(Agent agent) {
        bb = new BaseBelief(agent);
        agent.setBB(bb);
        switch(agent.getRole()){
            case "Mafia":
                bb.createEnemy();
            case "Townie":
                bb.createTownie();
        }
    }

    @Override
    public Object execute(TransitionSystem ts,
                          Unifier un, Term[] args) {
        return true;
    }


}
