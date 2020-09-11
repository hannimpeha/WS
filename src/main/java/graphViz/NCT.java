package graphViz;

import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Relationship;
import playerInfo.Doctor;
import playerInfo.Mafia;
import playerInfo.Townie;

import java.util.*;

public class NCT {

    private RelationshipType KNOWS;
    private RelationshipType SEND;
    private RelationshipType RECEIVE;
    private Label mafia, townies, doctor;
    private Node hyo, ji, yoo, mi, vi, se, ari;
    private Relationship relationship;
    private Random random = new Random();
    private List<RelationshipType> ordinary =
            Collections.unmodifiableList(Arrays.asList(SEND, RECEIVE));


    public NCT() {
        createFriendships(makePairsFromArray(createNode()));
    }

    private Node[] createNode(){
        hyo = new Mafia("hyojung", 0, 1, false);
        ji = new Townie("jiho",1, 1, false);
        yoo = new Doctor("yooa", 2, 1, false);
        mi = new Mafia("mimi", 0, 1, false);
        vi = new Townie("vinie", 1, 1, false);
        se = new Townie("seunghee", 1, 1, false);
        ari = new Townie("arin", 1, 1, false);
        return new Node[]{hyo, ji, yoo, mi, vi, se, ari};
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

    public static void main(String[] args) {
        new NCT();
    }
}
