package playerInfo;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Relationship;
import org.neo4j.ogm.annotation.*;

import java.util.Map;

@NodeEntity(label="mafia")
public class Mafia extends Player {

    public Mafia(String name, String role, int position) {
        super(name, role, position);
    }

    public Mafia(String name, String role, int position, int status, boolean target) {
        super(name, role, position, status, target);
    }

    public Mafia(Mafia mafia) {
        super(mafia);
    }


    @Override
    public Player copy() {
        return new Mafia(this);
    }

    @Override
    public int doAction(Player p) {
        return p.getStatus();
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
    public Iterable<Relationship> getRelationships(RelationshipType relationshipType, Direction direction) {
        return null;
    }

    @Override
    public boolean hasRelationship(RelationshipType relationshipType, Direction direction) {
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
    public long getId() {
        return 0;
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
