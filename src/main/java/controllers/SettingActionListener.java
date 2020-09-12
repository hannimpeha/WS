package controllers;

import org.neo4j.graphdb.Node;
import playerInfo.Player;

import java.awt.event.ActionListener;
import java.util.List;

public interface SettingActionListener extends ActionListener {
    List<Player> setAllPlayers();
    void saveGame();
}
