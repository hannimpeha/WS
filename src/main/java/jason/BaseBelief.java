package jason;

import jason.asSemantics.Agent;
import jason.asSemantics.Unifier;
import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.PredicateIndicator;
import jason.bb.BeliefBase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.Iterator;
import java.util.Set;

public class BaseBelief implements BeliefBase {

    public BaseBelief(Agent agent) {
        init(agent, new String[]{"I have to survive"});
    }

    public Literal createEnemy() {
        return Literal.parseLiteral("Save Townies");
    }

    public Literal createTownie() {
        return Literal.parseLiteral("Kill Mafia");
    }

    @Override
    public void init(Agent agent, String[] strings) {
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
