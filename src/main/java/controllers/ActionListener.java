package controllers;

import org.neo4j.graphdb.Node;
import playerInfo.Player;
import java.util.List;

public interface ActionListener {
    List<Player> setAllPlayers();
    List<Node> setAllNodes();
}
