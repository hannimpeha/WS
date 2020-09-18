package panels;

import logic.Game;
import logic.NightAction;
import logic.Victory;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class NightPanel {

    private List<String> playerName =
            Arrays.asList("hyo", "ji", "yoo", "mi", "vi", "se", "ari");
    private LoadFileUtil fu;
    private NightAction na;
    private Victory victory;

    public NightPanel() {
        fu = new LoadFileUtil(playerName);
    }

    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 40);
        textAreaOrder.setText("Night Start\n");
        victory = new Victory(fu.setAllPlayers());
        textAreaOrder.append(victory.victoryMessage());
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }

    public JButton createButton() {
        final JButton button = new JButton("Night");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                na = new NightAction();
                new Game(fu.setAllPlayers(), na.nightAction());
            }
        });
        return button;
    }

}