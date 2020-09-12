package graphViz;

import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

public class Agent extends jason.asSemantics.Agent {

    private final String name;
    private final String role;
    private final int status;
    private InternalAction ia;
    private TransitionSystem ts;
    private Unifier un;
    private Term[] args;

    public Agent(String name, String role, int status){
        this.name = name;
        this.role = role;
        this.status = status;
    }

    public void run(){
        ia = new InternalAction();
    }
}
