package panels;

import ballot.Voting;
import controllers.State;
import logic.Game;
import controllers.Hannah;
import util.LoadFileUtil;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class DayPanel implements State {

    private static JButton button;
    private List<String> playerName =
            Arrays.asList("hyo", "ji", "yoo", "mi", "vi", "se", "ari");
    private LoadFileUtil fu = new LoadFileUtil(playerName);
    private Voting vote = new Voting();
    private final JTextArea textAreaOrder = new JTextArea(20, 30);
    private final JTextField textField = new JTextField(24);
    private Hannah hannah;

    public DayPanel() {
    }

    public void doButton(Hannah hannah){
        new Game(fu.setAllPlayers(), vote.run());
    }

    @Override
    public void doContinue(Hannah hannah) {
        doButton(hannah);
        hannah.changeState(new NightPanel());

    }

    @Override
    public JTextArea getTextArea() {
        textAreaOrder.setText("Player "+vote.run()+" has been lynched");
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }

}