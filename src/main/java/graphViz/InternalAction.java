package graphViz;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

public class InternalAction extends DefaultInternalAction {

    private TransitionSystem ts;
    private Unifier un;
    private Term[] args;

    public InternalAction(){
        System.out.println("I Love you");
    }

}
