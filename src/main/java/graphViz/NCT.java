package graphViz;

import controllers.ActionListener;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Relationship;
import playerInfo.Player;

import java.util.*;

public class NCT {

    private ActionListener listener;
    private List<Player> playerInfo;
    private List<Node> playerNode;
    private RelationshipType KNOWS;
    private RelationshipType SEND;
    private RelationshipType RECEIVE;
    private Label mafia, townies, doctor;
    private Node hyo, ji, yoo, mi, vi, se, ari;
    private Relationship relationship;
    private Random random = new Random();
    private List<RelationshipType> ordinary =
            Collections.unmodifiableList(Arrays.asList(SEND, RECEIVE));
    private Node[] foo;
    private List<Agent> agentList = new ArrayList<Agent>();
    private TransitionSystem ts;
    private Unifier un;
    private Term[] args;

    public NCT(List<Player> playerInfo, List<Node> playerNode) {
        createFriendships(makePairsFromArray(createNode(playerNode)));
        createAgent(playerInfo).stream().forEach(Agent::run);
    }

    private List<Agent> createAgent(List<Player> playerInfo){
        for(Player p: playerInfo) {
            Agent ag = new Agent(p.getName(), p.getRole(), p.getStatus());
            agentList.add(ag);
        }
        return agentList;
    }


    private Node[] createNode(List<Node> playerInfo){
        foo = new Node[playerInfo.size()];
        return playerInfo.toArray(foo);
    }

    private void createFriendships(List<Node[]> pairs){
        for(Node[] node:pairs) {
            if(node[0].hasLabel(mafia) && node[1].hasLabel(mafia)) {
                node[0].createRelationshipTo(node[1], RelationshipType.withName("KNOWS"));
            } else {
                node[0].createRelationshipTo(node[1],
                        ordinary.get(random.nextInt(ordinary.size())));
            }

        }
    }


    public static List<Node[]> makePairsFromArray(Node[] arr) {
        List<Node[]> list = new ArrayList<>();

        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                Node[] pair = new Node[2];
                pair[0] = arr[i];
                pair[1] = arr[j];
                list.add(pair);
                Node[] opp = new Node[2];
                opp[0] = arr[j];
                opp[1] = arr[i];
                list.add(opp);
            }
        }
        return list;
    }

}
