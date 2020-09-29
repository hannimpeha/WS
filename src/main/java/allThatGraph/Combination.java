package allThatGraph;

import jason.Agents;
import jason.BaseBelief;
import jason.NCT;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import playerInfo.Player;
import util.LoadFileUtil;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Combination {

    private RelationshipType SEND;
    private RelationshipType RECEIVE;
    private RelationshipType KNOWS;
    private List<String[]> list = new ArrayList<String[]>();
    private List<String> arr = new ArrayList<>();
    private String path = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
            "FascinatingProject/src/main/java/resource/awesome.dot";
    private BaseBelief bb;
    private LoadFileUtil fu = new LoadFileUtil();
    private List<Player> playerInfo = fu.loadPlayer();
    private NCT nct = new NCT(playerInfo);
    private List<Agents> agents = nct.createAgent(playerInfo);
    private List<Node[]> nodes;
    private Agents agent;
    private List<RelationshipType> ordinary =
            Collections.unmodifiableList(Arrays.asList(SEND, RECEIVE));
    private Random random = new Random();

    public Combination() {

    }

    public void writeDot() {
        try(PrintStream out = new PrintStream(path, "UTF-8")) {
            out.print("digraph {\n");
            List<Agents[]> pairs = createFriendships(makePairsFromList(agents));
            for(Agents[] agent :pairs) {
                if(agent[0].getIAmSending()!=null) {
                    out.print(agent[0].getName() + "->" + agent[1].getName() + ";\n");
                }
            }
            out.println("}");
        }catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public List<Agents[]> createFriendships(List<Agents[]> pairs){
        List<Agents[]> ultimate = new ArrayList<>();
        for(Agents[] agent : pairs) {
            if(agent[0].getRole()=="Mafia" && agent[1].getRole()=="Mafia") {
                agent[0].createRelationshipTo(agent[1], KNOWS);
            } else {
                agent[0].createRelationshipTo(agent[1],
                        ordinary.get(random.nextInt(ordinary.size())));
            }
            ultimate.add(agent);
        }
        return ultimate;
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
