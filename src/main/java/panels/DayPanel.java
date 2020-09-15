package panels;

import ballot.Voting;
import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DayPanel {

    private Voting vote = new Voting();
    private LoadFileUtil fu;
    private List<Player> playerInfo;

    public DayPanel(LoadFileUtil fu) {
        this.fu = fu;
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
        box.setBorder(BorderFactory.createEmptyBorder(5, 1, 5, 1));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        final JButton continueButton = new JButton("Cont.");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fu.newFile(playerInfo, vote.run());
            }
        });
        box.add(continueButton);
        return box;
    }
}
