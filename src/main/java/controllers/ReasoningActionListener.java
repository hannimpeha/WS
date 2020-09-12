package controllers;


import org.neo4j.graphdb.Node;

import java.awt.event.ActionListener;
import java.util.List;

public interface ReasoningActionListener extends ActionListener {
    List<Node> setAllNodes();
}
