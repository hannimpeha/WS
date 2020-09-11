package jason;

import jason.agents.Doctor;
import jason.agents.Mafia;
import jason.agents.MyAgent;
import jason.agents.Townie;
import jason.asSyntax.Literal;
import jason.bb.DefaultBeliefBase;
import org.neo4j.graphdb.Label;


public class BaseBelief extends DefaultBeliefBase {

    private Label mafia;
    private Label townie;
    private Label doctor;
    private Mafia hyo;
    private Townie ji;
    private Doctor yoo;
    private Mafia mi;
    private Townie vi;
    private Townie se;
    private Townie ari;
    private MyAgent[] agents = new MyAgent[]{hyo, ji, yoo, mi, vi, se, ari};

    public BaseBelief() {
        add(Literal.parseLiteral("I have to survive"));
        formBelief(agents);
    }

    public void formBelief(MyAgent[] agents) {
        for (MyAgent p : agents) {
            if (p.hasLabel(mafia)) {
                add(Literal.parseLiteral("I am Mafia"));
            } else if (p.hasLabel(townie)) {
                add(Literal.parseLiteral("I am Townie"));
            } else {
                add(Literal.parseLiteral("I am Doctor"));
            }
        }
    }

}