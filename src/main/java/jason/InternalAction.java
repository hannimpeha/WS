package jason;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

public class InternalAction extends DefaultInternalAction {

    private MCT mct;

    public InternalAction(Agent agent) {
        mct = new MCT(agent);
        agent.setBB(mct);
    }

    @Override
    public Object execute(TransitionSystem ts,
                          Unifier un, Term[] args) {
        return true;
    }


}
