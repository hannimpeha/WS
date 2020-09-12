package jason;

import jason.architecture.AgArch;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

public class Agent extends jason.asSemantics.Agent {

    private final String name;
    private final String role;
    private final int status;
    private InternalAction ia;
    private  TransitionSystem ts = new TransitionSystem(this, null, null, new AgArch());
    private Unifier un = new Unifier();
    private Term[] args = new Term[]{};

    public Agent(String name, String role, int status){
        this.name = name;
        this.role = role;
        this.status = status;
    }

    public void run() {
        ia = new InternalAction(this);
        ia.execute(ts, un, args);
    }

    public String getName() {
        return name;
    }


    public String getRole() {
        return role;
    }

    public int getStatus(){
        return status;
    }

}
