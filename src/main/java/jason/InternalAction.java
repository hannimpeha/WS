package jason;

import jason.asSemantics.Agent;
import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InternalAction extends DefaultInternalAction {

    private BaseBelief bb;
    private Agents agent;
    private List<Agents> agentList;
    private Conjectures cj;
    private Map<String, Double> map;
    private String path = "/Users/hannimpeha/HANNIMPEHA/" +
                    "Thesis/FascinatingProject" +
                    "/src/main/java/resource/ballot-pre.txt";

    public InternalAction(List<Agents> agents) {
        bb = new BaseBelief(agents);
        for(int i=0; i<agents.size(); i++) {
            agent = new Agents(agents.get(i).getName(),
                    agents.get(i).getRole(),
                    agents.get(i).getStatus());
            agent.setBB(bb);
            //writeNetwork(agent);
        }
        gossiping(agents);
        probabilityConjecture(agents);
    }

    public void writeNetwork(Agent agent) {
        System.out.println(agent.getBB());
    }

    public void gossiping(List<Agents> agents) { new Messaging(agents); }

    public void probabilityConjecture(List<Agents> agents) {
        cj = new Conjectures(agents);
        map = cj.makingDecision(cj.makingDefault(agents));
        try {
            PrintStream out = new PrintStream(path, "UTF-8");
            map.keySet().stream()
                    .map(a-> a + ",")
                    .forEach(out::print);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object execute(TransitionSystem ts,
                          Unifier un, Term[] args) {
        return true;
    }

}
