package graphViz;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;
import jason.bb.BeliefBase;

public class InternalAction extends DefaultInternalAction {

    private BeliefBase bb;

    public InternalAction(){
        System.out.println("I am Great");
    }

    public Object execute(TransitionSystem ts,
                          Unifier un, Term[] args) {
        ts.getAg().setBB(bb);
        return true;
    }


}
