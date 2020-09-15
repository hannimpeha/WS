package panels;

import ballot.Voting;
import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class DayPanel {

    private LoadFileUtil fu = new LoadFileUtil();;
    private Voting vote = new Voting();
    private List<Player> playerInfo = new ArrayList<>();

    public DayPanel() {
        createPanel();
        createButton();
    }

    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 30);
        Voting vote = new Voting();
        textAreaOrder.setText("Player "+vote.run()+" has been lynched");
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }

    public Box createButton() {
        final Box box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        final JTextField textField = new JTextField(24);
        box.add(textField);
        final JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(new DayPanelActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fu.saveGame(playerInfo);
            }
            @Override
            public void deletePlayers(List<Player> playerInfo, String lynched) {
                fu.deletePlayers(playerInfo, vote.run());
            }

            @Override
            public void saveGameContinue(List<Player> playerInfo) {
                fu.saveGame(playerInfo);
            }
        });
        box.add(continueButton);
        return box;
    }
}
