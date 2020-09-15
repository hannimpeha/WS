package panels;

import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.util.List;

public class NightPanel {

    private List<Player> playerInfo;

    public NightPanel() {
    }

    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 30);
        textAreaOrder.setText("Night Start");
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }

}
