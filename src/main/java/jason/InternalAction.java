package jason;

import jason.asSemantics.*;
import jason.asSyntax.Term;


public class InternalAction extends DefaultInternalAction {

    public InternalAction(){
    }

    @Override
    public Object execute(TransitionSystem ts,
                          Unifier un,
                          Term[] args){
    return true;
    }



}
