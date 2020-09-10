package jason.agents;

import jason.MyCircumstance;
import jason.MyInternalAction;
import jason.architecture.AgArch;
import jason.asSemantics.Agent;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

import java.util.logging.Logger;

public class MyMafiaAgent extends AgArch {

    private TransitionSystem ts;
    private Unifier un;
    private Term[] term;
    private Logger logger = Logger.getLogger(MyMafiaAgent.class.getName());
    private MyCircumstance circumstance;

    public MyMafiaAgent(){
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
