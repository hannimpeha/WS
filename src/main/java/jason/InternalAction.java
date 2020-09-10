package jason;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

public class InternalAction extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts,
                          Unifier un,
                          Term[] args){
        think("hannah");
    return true;
    }

    void think(String agName) {
        System.out.println("I am thinking");
    }
}
