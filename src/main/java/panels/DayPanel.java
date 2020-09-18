package panels;

import ballot.Voting;
import logic.Game;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
                new Game(fu.setAllPlayers(), vote.run());
            }
        });
        return button;
    }

    public List<String> getSurvivor() {
        return fu.loadFile();
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