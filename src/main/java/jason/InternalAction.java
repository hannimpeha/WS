package jason;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

import java.util.List;


public class InternalAction extends DefaultInternalAction {

    private BaseBelief bb;
    private Agents agent;
    private List<Agents> agentList;

    public InternalAction(List<Agents> agents) {
        bb = new BaseBelief(agents);
        for(int i=0; i<agents.size(); i++) {
            agent = new Agents(agents.get(i).getName(),
                    agents.get(i).getRole(),
                    agents.get(i).getStatus());
            agent.setBB(bb);
            writeNetwork(agent);
        }
        gossiping(agents);
    }

    public void writeNetwork(Agents agent) {
        System.out.println(agent.getBB());
    }

    public void gossiping(List<Agents> agents) {
        new Messaging(agents);
    }

    // updating belief, writing voter's choice
    
    @Override
    public Object execute(TransitionSystem ts,
                          Unifier un, Term[] args) {
        return true;
    }

}
