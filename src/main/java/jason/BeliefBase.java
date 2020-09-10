package jason;

import jason.asSemantics.TransitionSystem;
import jason.asSyntax.Literal;
import jason.asSyntax.LiteralImpl;
import jason.bb.DefaultBeliefBase;

public class BeliefBase extends DefaultBeliefBase {

    protected Literal percepts = Literal.parseLiteral("I believe");
    private TransitionSystem ts;

    public BeliefBase(){
        percepts.addTerms(Literal.parseLiteral("I also love myself"));
    }

}
