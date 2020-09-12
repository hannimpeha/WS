package controllers;

import graphViz.MyRunnable;
import org.neo4j.graphdb.Node;
import playerInfo.Player;

import javax.swing.*;
import java.util.List;

public class Controller extends ConsolePane {

    public JFrame frame;
    public GameController gc;
    private ActionListener listener;

    public Controller() {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                initFrame();
            }
        });
    }

    public void run() {
        SwingUtilities.invokeLater(new MyRunnable(listener));
    }

    @Override
    public List<Player> setAllPlayers() {
        return setAllPlayers();
    }

    @Override
    public List<Node> setAllNodes() {
        return setAllNodes();
    }
}
