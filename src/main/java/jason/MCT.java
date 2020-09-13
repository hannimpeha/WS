package jason;

import jason.asSemantics.Unifier;
import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.PredicateIndicator;
import jason.bb.BeliefBase;
import org.neo4j.graphdb.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.*;

public class MCT implements BeliefBase {

    private RelationshipType SEND;
    private RelationshipType RECEIVE;
    private RelationshipType KNOWS;
    private static Label mafia, townies, doctor;
    private Random random = new Random();
    private List<RelationshipType> ordinary =
            Collections.unmodifiableList(Arrays.asList(SEND, RECEIVE));
    private List<Agent> playerAgent;

    public MCT(List<Agent> agents) {
                createFriendships(
                        makePairsFromList(agents));
    }


    public Relationship getRelationshipBetween(Node n1, Node n2) {
        for (Relationship rel : n1.getRelationships()) {
            if (rel.getOtherNode(n1).equals(n2)) return rel;
        }
        return null;
    }

    public List<Node[]> createFriendships(List<Node[]> pairs){
        for(Node[] node:pairs) {
            if(node[0].hasLabel(mafia) && node[1].hasLabel(mafia)) {
                node[0].createRelationshipTo(node[1], KNOWS);
            } else {
                node[0].createRelationshipTo(node[1],
                        ordinary.get(random.nextInt(ordinary.size())));
            }
        }
        return pairs;
    }

    public List<Node[]> createEachNetwork(List<Node[]> pairs) {
        for(Node[] node:pairs) {
            boolean weAreMafia = (node[0].getRelationshipTypes()==SEND);
            boolean iAmReceiving = (node[0].getRelationshipTypes()==RECEIVE);
            boolean iAmSending = (node[0].getRelationshipTypes()==SEND);
            if(weAreMafia) {
                node[0].createRelationshipTo(node[1], KNOWS);
            } else if (iAmReceiving) {
                node[0].createRelationshipTo(node[1], RECEIVE);
            } else if (iAmSending) {
                node[0].createRelationshipTo(node[1], SEND);
            } else {
                node[0].createRelationshipTo(node[1],
                        ordinary.get(random.nextInt(ordinary.size())));
            }
        }
        return pairs;
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


    public static List<Node[]> makePairsFromList(List<Agent> arr) {
        List<Node[]> list = new ArrayList<>();

        for(int i = 0; i < arr.size() - 1; i++) {
            for(int j = i + 1; j < arr.size(); j++) {
                Node[] pair = new Node[2];
                pair[0] = arr.get(i);
                pair[1] = arr.get(j);
                list.add(pair);
                Node[] opp = new Node[2];
                opp[0] = arr.get(j);
                opp[1] = arr.get(i);
                list.add(opp);
            }
        }
        return list;
    }

    @Override
    public void init(jason.asSemantics.Agent agent, String[] strings) {

    }

    @Override
    public Set<Atom> getNameSpaces() {
        return null;
    }

    @Override
    public void stop() {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean add(Literal literal) {
        return false;
    }

    @Override
    public boolean add(int i, Literal literal) {
        return false;
    }

    @Override
    public Iterator<Literal> iterator() {
        return null;
    }

    @Override
    public Iterator<Literal> getAll() {
        return null;
    }

    @Override
    public Iterator<Literal> getCandidateBeliefs(PredicateIndicator predicateIndicator) {
        return null;
    }

    @Override
    public Iterator<Literal> getCandidateBeliefs(Literal literal, Unifier unifier) {
        return null;
    }

    @Override
    public Iterator<Literal> getRelevant(Literal literal) {
        return null;
    }

    @Override
    public Literal contains(Literal literal) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<Literal> getPercepts() {
        return null;
    }

    @Override
    public boolean remove(Literal literal) {
        return false;
    }

    @Override
    public boolean abolish(PredicateIndicator predicateIndicator) {
        return false;
    }

    @Override
    public Element getAsDOM(Document document) {
        return null;
    }

    @Override
    public BeliefBase clone() {
        return null;
    }

}
