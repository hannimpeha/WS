package jason;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class InternalAction extends DefaultInternalAction {

    private BaseBelief bb;
    private Agents agent;
    private Conjectures cj;
    private String path = "/Users/hannimpeha/HANNIMPEHA/" +
                    "Thesis/FascinatingProject" +
                    "/src/main/java/resource/ballots.txt";

    public InternalAction(List<Agents> agents) {
        bb = new BaseBelief(agents);
        for (int i = 0; i < agents.size(); i++) {
            agent = new Agents(agents.get(i).getName(),
                    agents.get(i).getRole(),
                    agents.get(i).getStatus());
            agent.setBB(bb);
        }
        gossiping(agents);
        probabilityConjecture(agents);
    }

    public void gossiping(List<Agents> agents) { new Messaging(agents); }

    public void probabilityConjecture(List<Agents> agents) {
        try {
            PrintStream out = new PrintStream(path, "UTF-8");
            cj = new Conjectures(agents);
            cj.makingDefault()
                    .entrySet()
                    .forEach(a->out.print(
                            printing(a.getValue())
                                    .toString()
                                    .replaceAll("(^\\[|\\]$)", "")+"\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> printing(Map<String[], Double[]> values) {
        return values.entrySet()
                .stream()
                .map(a->Arrays.asList(a.getKey()))
                .map(a->a.toString().replaceAll("(^\\[|\\]$)", ""))
                .collect(Collectors.toList());
    }

    @Override
    public Object execute(TransitionSystem ts,
                          Unifier un, Term[] args) {
        return true;
    }

}
