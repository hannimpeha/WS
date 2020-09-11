package jason.agents;

import jason.GameCir;
import jason.InternalAction;
import jason.architecture.AgArch;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.DefaultTerm;
import jason.asSyntax.Term;
import org.neo4j.graphdb.*;

import java.util.Map;

public class MyAgent extends AgArch implements Node {

    private TransitionSystem ts;
    private Unifier un;
    private Term[] term = new Term[]{townie, mafia};
    private GameCir cir;
    private static Term townie = DefaultTerm.parse("townie");
    private static Term mafia = DefaultTerm.parse("mafia");

    public MyAgent(String name, String role){

    }

    private AgArch production(String name, String role){
        switch(role) {
            case "Mafia": return new Mafia(name, role);
            case "Doctor": return new Doctor(name, role);
            default : return new Townie(name, role);
        }
    }

    public void run() {
        InternalAction action = new InternalAction();
        action.execute(ts, un, term);
    }

    @Override
    public void delete() {
    }

    @Override
    public Iterable<Relationship> getRelationships() {
        return null;
    }

    @Override
    public boolean hasRelationship() {
        return false;
    }

    @Override
    public Iterable<Relationship> getRelationships(RelationshipType... relationshipTypes) {
        return null;
    }

    @Override
    public Iterable<Relationship> getRelationships(Direction direction, RelationshipType... relationshipTypes) {
        return null;
    }

    @Override
    public boolean hasRelationship(RelationshipType... relationshipTypes) {
        return false;
    }

    @Override
    public boolean hasRelationship(Direction direction, RelationshipType... relationshipTypes) {
        return false;
    }

    @Override
    public Iterable<Relationship> getRelationships(Direction direction) {
        return null;
    }

    @Override
    public boolean hasRelationship(Direction direction) {
        return false;
    }

    @Override
    public Relationship getSingleRelationship(RelationshipType relationshipType, Direction direction) {
        return null;
    }

    @Override
    public Relationship createRelationshipTo(Node node, RelationshipType relationshipType) {
        return null;
    }

    @Override
    public Iterable<RelationshipType> getRelationshipTypes() {
        return null;
    }

    @Override
    public int getDegree() {
        return 0;
    }

    @Override
    public int getDegree(RelationshipType relationshipType) {
        return 0;
    }

    @Override
    public int getDegree(Direction direction) {
        return 0;
    }

    @Override
    public int getDegree(RelationshipType relationshipType, Direction direction) {
        return 0;
    }

    @Override
    public void addLabel(Label label) {

    }

    @Override
    public void removeLabel(Label label) {

    }

    @Override
    public boolean hasLabel(Label label) {
        return false;
    }

    @Override
    public Iterable<Label> getLabels() {
        return null;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public boolean hasProperty(String s) {
        return false;
    }

    @Override
    public Object getProperty(String s) {
        return null;
    }

    @Override
    public Object getProperty(String s, Object o) {
        return null;
    }

    @Override
    public void setProperty(String s, Object o) {

    }

    @Override
    public Object removeProperty(String s) {
        return null;
    }

    @Override
    public Iterable<String> getPropertyKeys() {
        return null;
    }

    @Override
    public Map<String, Object> getProperties(String... strings) {
        return null;
    }

    @Override
    public Map<String, Object> getAllProperties() {
        return null;
    }
}
