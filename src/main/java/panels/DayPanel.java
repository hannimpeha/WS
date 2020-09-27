package panels;

import ballot.Voting;
import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class DayPanel implements State {

    protected LoadFileUtil fu = new LoadFileUtil();
    protected Voting vote = new Voting();
    protected String victim = vote.run();
    protected List<Player> playerInfo = fu.loadPlayer();

    public DayPanel() {
    }

    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 40);
        textAreaOrder.setText("There are "+playerInfo.size()+" number of Players\n");
        textAreaOrder.append("Player "+victim+" has been lynched");
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }


    public JButton createButton() {
        final JButton button = new JButton("Day");
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
        student.setState(new NightPanel());
        return createPanel();
    }

    @Override
    public JTextArea onExitAbove(Student student) {
        return createPanel();
    }

    @Override
    public JButton onPlayBottom(Student student) {
        student.setState(new NightPanel());
        return createButton();
    }

    @Override
    public JButton onExitBottom(Student student) {
        return createButton();
    }

    @Override
    public String getName() {
        return "Day";
    }
}