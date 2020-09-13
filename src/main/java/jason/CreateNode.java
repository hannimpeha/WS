package jason;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public interface CreateNode extends GraphDatabaseService {

    Node createNode();
}
