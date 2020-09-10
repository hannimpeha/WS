package jason;

import jason.asSemantics.TransitionSystem;
import jason.asSyntax.Literal;
import jason.asSyntax.LiteralImpl;
import jason.bb.DefaultBeliefBase;

public class MyBeliefBase extends DefaultBeliefBase {

    private Literal percepts = Literal.parseLiteral("I believe");
    private TransitionSystem ts;

    public MyBeliefBase(){
    }
    void run(){
        percepts.addTerms(Literal.parseLiteral("I also love myself"));
    }

}
