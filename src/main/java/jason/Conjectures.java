package jason;

import java.util.*;

public class Conjectures {

    private List<Double> defaultConjecture = new ArrayList<>();
    private List<String> finalConjecture = new ArrayList<>();
    private List<Map> wow = new ArrayList<>();
    private Map<String, List> sub = new TreeMap<>();
    private Map<List, List> subsub = new TreeMap<>();
    private List<Agents> agents;
    private List<String> names;

    public Conjectures(List<Agents> agents){
        this.agents = agents;
    }


    public Map<String, List> makingDefault() {
        for(int i=0; i<agents.size(); i++) {
            double rand = Math.random();
            if (agents.get(i).getRole() != "Mafia") {
                defaultConjecture = new ArrayList<Double>(
                        Arrays.asList(rand /2 , rand / 3, rand /4 , rand /5 , rand / 6 , rand /7 , rand /8 ));
            } else {
                defaultConjecture = new ArrayList<Double>(
                        Arrays.asList(rand / 2, rand / 2, rand / 2, rand / 2, rand / 2, rand / 2, rand / 2));
            }
            Collections.sort(defaultConjecture, Comparator.reverseOrder());
            sub.put(agents.get(i).getName(), defaultConjecture);
        }
        return sub;
    }


}
