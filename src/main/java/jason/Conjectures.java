package jason;

import java.util.*;

public class Conjectures {

    private List<Double> defaultConjecture = new ArrayList<>();
    private List<Agents> agents;
    private Map<String, Double> map = new TreeMap<>();

    public Conjectures(List<Agents> agents){
        this.agents = agents;
    }


    public List<Double> makingDefault(List<Agents> agents) {
        for (Agents agent : agents) {
            if (agent.getRole() != "Mafia") {
                double rand = Math.random();
                if (rand < 2 / 6) {
                    defaultConjecture.add(rand);
                }
            } else {
                double rand = Math.random();
                defaultConjecture = new ArrayList<Double>(
                        Arrays.asList(rand, rand, rand, rand, rand, rand, rand));
            }
        }
        return defaultConjecture;
    }

    public Map<String, Double> makingDecision(List<Double> doubles) {
        for(int i=0; i<doubles.size(); i++){
            map.put(agents.get(i).getName(),doubles.get(i));
        }
    return map;
    }
}
