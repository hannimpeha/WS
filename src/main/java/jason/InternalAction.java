package jason;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

import java.util.List;


public class InternalAction extends DefaultInternalAction {

    private MCT mct;
    private Agent agent;
    private List<Agent> agentList;

    public InternalAction(List<Agent> agents) {
        mct = new MCT(agents);
        for(int i=0; i<agents.size(); i++) {
            agent = new Agent(agents.get(i).getName(),
                    agents.get(i).getRole(),
                    agents.get(i).getStatus());
            agent.setBB(mct);
            writeNetwork(agent);
        }
        gossiping(agents);
    }

    public void writeNetwork(Agent agent) {
        System.out.println(agent.getBB());
    }

    public void gossiping(List<Agent> agents) {
        new MyMessage(agents);
    }

    @Override
    public Object execute(TransitionSystem ts,
                          Unifier un, Term[] args) {
        return true;
    }

}
