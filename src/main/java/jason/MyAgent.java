package jason;

import jason.architecture.AgArch;
import jason.asSemantics.*;
import jason.asSyntax.*;

import java.util.logging.Logger;

public class MyAgent extends AgArch{

    private TransitionSystem ts;
    private Unifier un;
    private Term[] term = new Term[]{townie, mafia};
    private MyCircumstance cir;

    static Trigger focus = new Trigger(Trigger.TEOperator.add,
            Trigger.TEType.achieve,
            Literal.parseLiteral("save Mafia"));
    static Term townie = DefaultTerm.parse("townie");
    static Term mafia = DefaultTerm.parse("mafia");

    public MyAgent()  {
        Agent ag = new Agent();
        ts = new TransitionSystem(ag, cir, null, this);
    }

    public String getAgName(){
        return "hannah";
    }

    public void run() {
        MyInternalAction action = new MyInternalAction();
        action.execute(ts, un, term);
    }


}
