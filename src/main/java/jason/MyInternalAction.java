package jason;

import jason.asSemantics.*;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;


public class MyInternalAction extends DefaultInternalAction {

    private Message message = new MyMessage();
    private Literal perceptsT = Literal.parseLiteral("I am Townie");
    private Literal perceptsM = Literal.parseLiteral("I am Mafia");
    private MyBeliefBase bb = new MyBeliefBase();
    private MyMessage mm = new MyMessage();
    private Intention in;

    @Override
    public Object execute(TransitionSystem ts,
                          Unifier un,
                          Term[] args){
        new ActionExec(perceptsT, in);


    return true;
    }



}
