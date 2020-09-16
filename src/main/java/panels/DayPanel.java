package panels;

import ballot.Voting;
import controllers.ConsolePane;
import logic.Game;
import controllers.Hannah;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class DayPanel {

    private static Hannah hannah;
    private static Box box = Box.createHorizontalBox();
    private static JTextField textField = new JTextField(24);
    private static JButton button = new JButton("Enter");
    private static JTextArea textAreaOrder = new JTextArea(20, 30);
    private List<String> playerName =
            Arrays.asList("hyo", "ji", "yoo", "mi", "vi", "se", "ari");
    private LoadFileUtil fu = new LoadFileUtil(playerName);
    private Voting vote = new Voting();

    public DayPanel() {
    }

    public JTextArea createPanel() {
        textAreaOrder.setText("Player "+vote.run()+" has been lynched");
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }

    public Box doButton(){
        box.setBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        box.add(textField);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Game(fu.setAllPlayers(), vote.run());
            }
        });
        box.add(button);
        return box;
    }
}