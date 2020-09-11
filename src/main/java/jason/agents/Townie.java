package jason.agents;

import jason.GameCir;
import jason.InternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.DefaultTerm;
import jason.asSyntax.Term;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label="Townie")
public class Townie extends MyAgent {

    private TransitionSystem ts;
    private Unifier un;
    private Term[] term = new Term[]{townie, mafia};
    private GameCir cir;
    private static Term townie = DefaultTerm.parse("townie");
    private static Term mafia = DefaultTerm.parse("mafia");
    @Relationship
    private String role = "Townie";

    public Townie(String name, String role)  {
        super(name, role);
    }

    public void run() {
        InternalAction action = new InternalAction();
        action.execute(ts, un, term);
    }

    public String getAgName() {
        return getAgName();
    }

    public String getRole() {
        return role;
    }

}
