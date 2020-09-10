package jason;

import jason.architecture.AgArch;
import jason.asSemantics.Agent;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;
import java.util.logging.Logger;

public class MyAgent extends AgArch {

    private TransitionSystem ts;
    private Unifier un;
    private Term[] term;
    private Logger logger = Logger.getLogger(MyAgent.class.getName());

    public MyAgent()  {
        Agent ag = new Agent();
        ts = new TransitionSystem(ag, null, null, this);
    }

    public String getAgName(){
        return "hannah";
    }

    public void run() {
        InternalAction action = new InternalAction();
        action.execute(ts, un, term);

    }

}
