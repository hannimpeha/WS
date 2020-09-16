package panels;

import controllers.ConsolePane;
import logic.Game;
import logic.NightAction;
import logic.Victory;
import stateMachine.Hannah;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class NightPanel extends ConsolePane {

    private Hannah hannah;
    private List<String> playerName =
            Arrays.asList("ji", "yoo", "mi", "vi", "se", "ari");
    private LoadFileUtil fu;
    private NightAction na;
    private Victory victory;

    public NightPanel(Hannah hannah) {
        this.hannah = hannah;
        doButton();
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

    public void doButton() {
        getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               na = new NightAction();
               new Game(fu.setAllPlayers(), na.nightAction());
            }
        });
    }

}