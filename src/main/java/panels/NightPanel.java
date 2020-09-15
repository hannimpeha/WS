package panels;

import logic.Victory;
import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class NightPanel {

    private List<String> playerName =
            Arrays.asList("ji", "yoo", "mi", "vi", "se", "ari");
    private LoadFileUtil fu;
    private List<Player> playerInfo;
    private Victory victory;


    public NightPanel() {
    }

    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 30);
        textAreaOrder.setText("Night Start\n");
        fu = new LoadFileUtil(playerName);
        victory = new Victory(fu.setAllPlayers());
        textAreaOrder.append(victory.victoryMessage());
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }

}