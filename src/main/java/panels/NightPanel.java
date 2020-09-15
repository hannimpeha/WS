package panels;

import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class NightPanel {

    private LoadFileUtil fu = new LoadFileUtil();;
    private List<Player> playerInfo;

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

    public Box createButton() {
        final Box box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        final JTextField textField = new JTextField(24);
        box.add(textField);
        final JButton victoryButton = new JButton("Victory");
        victoryButton.addActionListener(new NightPanelActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fu.saveGame(playerInfo);
            }

            @Override
            public void saveGameContinue(List<Player> playerInfo) {
                fu.saveGame(playerInfo);
            }
        });

        box.add(victoryButton);
        return box;
    }
}
