package panels;

import ballot.Voting;
import logic.Game;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class DayPanel {

    private List<String> playerName =
            Arrays.asList("hyo", "ji", "yoo", "mi", "vi", "se", "ari");
    private LoadFileUtil fu = new LoadFileUtil(playerName);
    private Voting vote = new Voting();

    public DayPanel() {
    }

    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 40);
        textAreaOrder.setText("Player "+vote.run()+" has been lynched");
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }


    public JButton createButton() {
        final JButton button = new JButton("Day");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Game(fu.setAllPlayers(), vote.run());
            }
        });
        return button;
    }

}