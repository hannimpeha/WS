package panels;

import ballot.Voting;

import javax.swing.*;

public class NightPanel {
    public NightPanel() {
        createPanel();
    }

    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 30);
        textAreaOrder.setText("Night Start");
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }
}
