package panels;

import logic.NightAction;
import logic.Victory;
import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class NightPanel implements State {

    protected LoadFileUtil fu = new LoadFileUtil();;
    protected NightAction na = new NightAction();
    protected Victory victory;
    protected String victim = na.nightAction();
    protected List<Player> playerInfo = fu.loadPlayer();

    public NightPanel() {
    }

    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 40);
        textAreaOrder.setText("Night Start\n");
        victory = new Victory(fu.setAllPlayers());
        textAreaOrder.append(victory.victoryMessage());
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }

    public JButton createButton() {
        final JButton button = new JButton("Night");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fu.saveGame(playerInfo.stream()
                        .filter(a->a.getName().contains(victim))
                        .collect(Collectors.toList()));
            }
        });
        return button;
    }


    @Override
    public JTextArea onPlayAbove(Student student) {
        return createPanel();
    }

    @Override
    public JTextArea onExitAbove(Student student) {
        return createPanel();
    }

    @Override
    public JButton onPlayBottom(Student student) {
        student.setState(new DayPanel());
        return createButton();
    }

    @Override
    public JButton onExitBottom(Student student) {
        return createButton();
    }

    @Override
    public String getName() {
        return "Night";
    }
}