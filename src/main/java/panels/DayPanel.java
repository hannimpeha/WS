package panels;

import ballot.Voting;

import javax.swing.*;

public class DayPanel {

    public DayPanel() {
        createPanel();
    }

    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 30);
        Voting vote = new Voting();
        textAreaOrder.setText("Player "+vote.run()+" has been lynched");
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }
}
