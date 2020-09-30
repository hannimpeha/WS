package thatGraph;

import jason.Agents;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Combination {

    private enum RelTypes implements RelationshipType
    {
        KNOWS, RECEIVE, SEND
    }
    private List<String[]> list = new ArrayList<String[]>();
    private List<String> arr = new ArrayList<>();
    private String path = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
            "FascinatingProject/src/main/java/resource/awesome.dot";
    private List<Node[]> nodes;
    private List<Agents> agents;
    private List<RelationshipType> ordinary =
            Collections.unmodifiableList(Arrays.asList(RelTypes.SEND, RelTypes.RECEIVE));
    private Random random = new Random();

    public Combination(List<Agents> agents) {
        this.agents = agents;
    }

    public void writeDot() {
        createFriendships(makePairsFromList(agents));
    }

    public void createFriendships(List<Agents[]> pairs){
        try(PrintStream out = new PrintStream(path, "UTF-8")) {
            out.print("digraph {\n");
            for (Agents[] agent : pairs) {
                if (agent[0].getRole().contains("Mafia")&&agent[1].getRole().contains("Mafia")) {
                    //agent[0].getWeAreMafia().add(agent[0].getName());
                    //agent[0].createRelationshipTo(agent[1], RelTypes.KNOWS);
                    out.print(agent[0].getName() + "->" + agent[1].getName() + ";\n");

                } else if (random.nextInt(ordinary.size()) == 0) {
                    //agent[0].getIAmSending().add(agent[0].getName());
                    out.print(agent[0].getName() + "->" + agent[1].getName() + ";\n");
                }
            }
            out.print("}");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static List<Agents[]> makePairsFromList(List<Agents> arr) {
        List<Agents[]> list = new ArrayList<>();

        for(int i = 0; i < arr.size() - 1; i++) {
            for(int j = i + 1; j < arr.size(); j++) {
                Agents[] pair = new Agents[2];
                pair[0] = arr.get(i);
                pair[1] = arr.get(j);
                list.add(pair);
                Agents[] opp = new Agents[2];
                opp[0] = arr.get(j);
                opp[1] = arr.get(i);
                list.add(opp);
            }
        }
        return list;
    }

    public List<String[]> combination
            (String[] arr, int len, int startPosition, String[] result) {
        if (len == 0) {
            //System.out.println(Arrays.toString(result));
            return null;
        }
        for (int i = startPosition; i <= arr.length - len; i++) {
            result[result.length - len] = arr[i];
            combination(arr, len - 1, i + 1, result);
            list.add(result.clone());
        }
        return list;
    }

}