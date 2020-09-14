package jason;

import jason.architecture.AgArch;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;
import org.neo4j.graphdb.*;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Agent extends jason.asSemantics.Agent implements Node {

    private final String name;
    private final String role;
    private final int status;
    @Relationship(type="RECEIVE", direction = "INCOMING")
    private Set<Agent> iAmReceiving = new HashSet<>();
    @Relationship(type="SEND", direction = "OUTGOING")
    private Set<Agent> iAmSending = new HashSet<>();
    @Relationship(type="KNOWS")
    private Set<Agent> weAreMafia = new HashSet<>();
    private InternalAction ia;
    private  TransitionSystem ts =
            new TransitionSystem(this, null, null, new AgArch());
    private Unifier un = new Unifier();
    private Term[] args = new Term[]{};

    public Agent(String name, String role, int status){
        this.name = name;
        this.role = role;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getRole(){ return role; }

    public int getStatus(){ return status; }

    public Set<Agent> getWeAreMafia() { return weAreMafia; }

    public Set<Agent> getiAmReceiving() { return iAmReceiving; }

    public Set<Agent> getiAmSending() { return iAmSending; }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public void delete() {
    }

    @Override
    public Iterable<org.neo4j.graphdb.Relationship> getRelationships() {
        return null;
    }

    @Override
    public boolean hasRelationship() {
        return false;
    }

    @Override
    public Iterable<org.neo4j.graphdb.Relationship> getRelationships(RelationshipType... relationshipTypes) {
        return null;
    }

    @Override
    public Iterable<org.neo4j.graphdb.Relationship> getRelationships(Direction direction, RelationshipType... relationshipTypes) {
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
    public Iterable<org.neo4j.graphdb.Relationship> getRelationships(Direction direction) {
        return null;
    }

    @Override
    public boolean hasRelationship(Direction direction) {
        return false;
    }

    @Override
    public Iterable<org.neo4j.graphdb.Relationship> getRelationships(RelationshipType relationshipType, Direction direction) {
        return null;
    }

    @Override
    public boolean hasRelationship(RelationshipType relationshipType, Direction direction) {
        return false;
    }

    @Override
    public org.neo4j.graphdb.Relationship getSingleRelationship(RelationshipType relationshipType, Direction direction) {
        return null;
    }

    @Override
    public org.neo4j.graphdb.Relationship createRelationshipTo(Node node, RelationshipType relationshipType) {
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
    public Traverser traverse(Traverser.Order order, StopEvaluator stopEvaluator, ReturnableEvaluator returnableEvaluator, RelationshipType relationshipType, Direction direction) {
        return null;
    }

    @Override
    public Traverser traverse(Traverser.Order order, StopEvaluator stopEvaluator, ReturnableEvaluator returnableEvaluator, RelationshipType relationshipType, Direction direction, RelationshipType relationshipType1, Direction direction1) {
        return null;
    }

    @Override
    public Traverser traverse(Traverser.Order order, StopEvaluator stopEvaluator, ReturnableEvaluator returnableEvaluator, Object... objects) {
        return null;
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
    public GraphDatabaseService getGraphDatabase() {
        return null;
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
}
