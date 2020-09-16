package panels;

import ballot.Voting;
import controllers.ConsolePane;
import logic.Game;
import stateMachine.Hannah;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class DayPanel extends ConsolePane {

    private List<String> playerName =
            Arrays.asList("hyo", "ji", "yoo", "mi", "vi", "se", "ari");
    private LoadFileUtil fu = new LoadFileUtil(playerName);
    private Voting vote = new Voting();

    public DayPanel(Hannah hannah) {
        super(hannah);
        createPanel();
        doButton();
    }

    public void createPanel() {
        getTextAreaOrder().setText("Player "+vote.run()+" has been lynched");
        getTextAreaOrder().setEditable(false);
    }

    public void doButton() {
        getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Game(fu.setAllPlayers(), vote.run());
            }
        });
    }
}