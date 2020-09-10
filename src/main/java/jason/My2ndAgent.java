package jason;

import jason.architecture.AgArch;
import jason.asSemantics.Agent;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

import java.util.logging.Logger;

public class My2ndAgent extends AgArch {

    private TransitionSystem ts;
    private Unifier un;
    private Term[] term;
    private Logger logger = Logger.getLogger(My2ndAgent.class.getName());
    private MyCircumstance circumstance;

    public My2ndAgent(){
        Agent ag = new Agent();
        ts = new TransitionSystem(ag, circumstance, null, this);
    }

    public String getAgName(){
        return "mafia";
    }

    public void run() {
        MyInternalAction action = new MyInternalAction();
        action.execute(ts, un, term);

    }
}
