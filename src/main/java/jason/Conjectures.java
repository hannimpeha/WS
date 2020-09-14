package jason;

import java.util.*;

public class Conjectures {

    private List<Double> defaultConjecture = new ArrayList<>();
    private Map<String, List> sub = new TreeMap<>();
    private List<Agents> agents;

    public Conjectures(List<Agents> agents){
        this.agents = agents;
    }


    public Map<String, List> makingDefault() {
        for(Agents agent: agents) {
            double rand = Math.random();
            if (agent.getRole() != "Mafia") {
                defaultConjecture = new ArrayList<Double>(
                        Arrays.asList(rand, rand, rand, rand, rand, rand, rand));
            } else {
                defaultConjecture = new ArrayList<Double>(
                        Arrays.asList(rand / 2, rand / 2, rand / 2, rand / 2, rand / 2, rand / 2, rand / 2));
            }
            sub.put(agent.getName(), defaultConjecture);
        }
        return sub;
    }
}
