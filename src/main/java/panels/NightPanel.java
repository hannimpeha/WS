package panels;

import controllers.Hannah;
import controllers.State;
import logic.Game;
import logic.NightAction;
import logic.Victory;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class NightPanel implements State {

    private List<String> playerName =
            Arrays.asList("ji", "yoo", "mi", "vi", "se", "ari");
    private LoadFileUtil fu;
    private NightAction na;
    private Victory victory;

    public NightPanel() {
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

    public Box createButton() {
        final Box box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(5, 1, 5, 1));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        final JButton continueButton = new JButton("Cont..");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                na = new NightAction();
                new Game(fu.setAllPlayers(), na.nightAction());
            }
        });
        box.add(continueButton);
        return box;
    }

    @Override
    public JTextArea doContinue(Hannah hannah) {
        hannah.changeState(new DayPanel());
        return createPanel();
    }

    @Override
    public String getThis() {
        return null;
    }
}