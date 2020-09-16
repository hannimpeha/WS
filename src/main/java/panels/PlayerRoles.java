package panels;

import controllers.ConsolePane;
import jason.NCT;
import jason.infra.centralised.RunCentralisedMAS;
import controllers.Hannah;
import stateMachine.DayState;
import stateMachine.State;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class PlayerRoles extends ConsolePane {

    private static Hannah hannah;
    private static Box box = Box.createHorizontalBox();
    private static JTextField textField = new JTextField(24);
    private static JButton button = new JButton("Enter");
    private static JTextArea textAreaOrder = new JTextArea(20, 30);
    private List<String> playerName =
            Arrays.asList("hyo", "ji", "yoo", "mi", "vi", "se", "ari");
    private LoadFileUtil fu = new LoadFileUtil(playerName);
    private List<String> playerRole;

    public PlayerRoles(Hannah hannah) {
        super(hannah);
        getNorthPane().add(createPanel());
        getSouthPane().add(doButton());
    }

    public JTextArea createPanel() {
        playerRole = fu.createRoles(playerName);
        textAreaOrder.setText("Assigned Roles are as follows\n");
        for(int i=0; i<playerName.size(); i++) {
            textAreaOrder.append(playerName.get(i)+" is "+playerRole.get(i)+".\n");
        }
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
                new RunCentralisedMAS();
                new NCT(fu.setAllPlayers());
            }
        });
        box.add(button);
        return box;
    }

}