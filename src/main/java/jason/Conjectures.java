package jason;

import java.util.*;

public class Conjectures {

    private Double[] defaultConjecture = new Double[]{};
    private Map<String, Map> sub = new HashMap<>();
    private Map<String[], Double[]> subsub = new HashMap<>();
    private List<Agents> agents;
    private String[] names = new String[]{"hyo", "ji", "yoo", "mi", "vi", "se", "ari"};

    public Conjectures(List<Agents> agents){
        this.agents = agents;
    }

    public Map<String, Map> makingDefault() {
        for(Agents agent: agents) {
            double rand = Math.random();
            if (agent.getRole() != "Mafia") {
                defaultConjecture = new Double[]{rand /2 , rand / 3, rand /4 , rand /5 , rand / 6 , rand /7 , rand /8};
            } else {
                defaultConjecture = new Double[]{rand / 2, rand / 2, rand / 2, rand / 2, rand / 2, rand / 2, rand / 2};
            }
            subsub.put(names, defaultConjecture);
            sub.put(agent.getName(), subsub);
        }
        return sub;
    }


}
