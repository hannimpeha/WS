package jason;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;
import playerInfo.Player;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class InternalAction extends DefaultInternalAction {

    private BaseBelief bb;
    private List<Agents> agents;
    private Conjectures cj;
    private String path = "/Users/hannimpeha/HANNIMPEHA/" +
                    "Thesis/FascinatingProject" +
                    "/src/main/java/resource/ballots.txt";

    public InternalAction(List<Player> playerInfo) {
        agents = createAgent(playerInfo);
        bb = new BaseBelief(agents);
        for(Agents agent: agents) {
            agent.setBB(bb);
        }
        gossiping(agents);
        probabilityConjecture(playerInfo);
    }

    public List<Agents> createAgent(List<Player> playerInfo){
        return playerInfo.stream()
                .filter(a->a.getStatus()!=0)
                .map(a->new Agents(a.getName(), a.getRole(), a.getStatus()))
                .collect(Collectors.toList());
    }

    public void gossiping(List<Agents> agents) { new Messaging(agents); }

    public void probabilityConjecture(List<Player> playerInfo) {
        try {
            PrintStream out = new PrintStream(path, "UTF-8");
            cj = new Conjectures(playerInfo);
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

    private List<String> printing(Map<List<String>, List<Double>> values) {
        return values.entrySet()
                .stream()
                //.map(a->Arrays.asList(a.getKey()))
                .map(a->a.getKey())
                .map(a->a.toString().replaceAll("(^\\[|\\]$)", ""))
                .collect(Collectors.toList());
    }

    @Override
    public Object execute(TransitionSystem ts,
                          Unifier un, Term[] args) {
        return true;
    }

}
