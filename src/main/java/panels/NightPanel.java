package panels;

import controllers.ConsolePane;
import controllers.State;
import logic.Game;
import logic.NightAction;
import logic.Victory;
import controllers.Hannah;
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
    private final JTextArea textAreaOrder = new JTextArea(20, 30);
    private final JTextField textField = new JTextField(24);
    private Hannah hannah;

    public NightPanel() {
    }

    public void doButton(Hannah hannah){
        na = new NightAction();
        new Game(fu.setAllPlayers(), na.nightAction());
    }

    @Override
    public void doContinue(Hannah hannah) {
        doButton(hannah);
        hannah.changeState(new DayPanel());
    }

    @Override
    public JTextArea getTextArea() {
        textAreaOrder.setText("Night Start\n");
        fu = new LoadFileUtil(playerName);
        victory = new Victory(fu.setAllPlayers());
        textAreaOrder.append(victory.victoryMessage());
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }
}