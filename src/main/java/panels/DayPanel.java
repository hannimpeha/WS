package panels;

import ballot.Voting;
import logic.Game;
import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class DayPanel implements State {

    private LoadFileUtil fu = new LoadFileUtil();
    private List<String> playerName = fu.loadFile();
    private Voting vote = new Voting();
    private Student student;

    public DayPanel() {
    }

    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 40);
        textAreaOrder.setText("There are "+playerName.size()+" number of Players\n");
        textAreaOrder.append("Player "+vote.run()+" has been lynched");
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }


    public JButton createButton() {
        final JButton button = new JButton("Day");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fu.saveGame(remainingPlayer(fu.loadPlayer(), vote.run()));
                new Game(fu.loadPlayer(), vote.run());
            }
        });
        return button;
    }

    private List<Player> remainingPlayer(List<Player> playerInfo, String lynched) {
        return playerInfo.stream()
                .filter(a -> a.getName() == lynched)
                .collect(Collectors.toList());
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