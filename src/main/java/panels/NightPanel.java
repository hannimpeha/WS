package panels;

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

public class NightPanel extends JPanel {

    private static Hannah hannah;
    private static JPanel contentPane = new JPanel();
    private static JPanel north = new JPanel();
    private static JPanel south = new JPanel();
    private List<String> playerName =
            Arrays.asList("ji", "yoo", "mi", "vi", "se", "ari");
    private LoadFileUtil fu;
    private NightAction na;
    private Victory victory;
    private static JButton button = new JButton("Enter");
    private static JTextArea textAreaOrder = new JTextArea(20, 30);
    private static Box box = Box.createHorizontalBox();
    private static JTextField textField = new JTextField(24);

    public NightPanel() {
        north.add(createPanel());
        south.add(doButton());
    }

    public JTextArea createPanel() {
        textAreaOrder.setText("Night Start\n");
        fu = new LoadFileUtil(playerName);
        victory = new Victory(fu.setAllPlayers());
        textAreaOrder.append(victory.victoryMessage());
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
               na = new NightAction();
               new Game(fu.setAllPlayers(), na.nightAction());
            }
        });
        box.add(button);
        return box;
    }

}