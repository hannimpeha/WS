package panels;

import logic.Game;
import logic.NightAction;
import logic.Victory;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NightPanel implements State {

    private LoadFileUtil fu = new LoadFileUtil();;
    private NightAction na;
    private Victory victory;
    private Student student;

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
                na = new NightAction();
                new Game(fu.loadPlayer(), na.nightAction());
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