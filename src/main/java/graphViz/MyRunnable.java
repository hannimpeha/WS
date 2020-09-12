package graphViz;

import controllers.ActionListener;
import jason.infra.centralised.RunCentralisedMAS;
import org.neo4j.graphdb.Node;
import playerInfo.Player;

import java.util.List;

public class MyRunnable implements Runnable {

    private ActionListener listener;
    private List<Player> playerInfo;
    private List<Node> playerNode;

    public MyRunnable(ActionListener listener) {
        this.listener = listener;
        new RunCentralisedMAS();
    }

    @Override
    public void run() {
        new NCT(listener);
    }

}
