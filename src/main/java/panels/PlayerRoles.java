package panels;

import controllers.State;
import jason.NCT;
import jason.infra.centralised.RunCentralisedMAS;
import controllers.Hannah;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class PlayerRoles implements State {

    private List<String> playerName =
            Arrays.asList("hyo", "ji", "yoo", "mi", "vi", "se", "ari");
    private LoadFileUtil fu = new LoadFileUtil(playerName);
    private List<String> playerRole;
    private final JTextArea textAreaOrder = new JTextArea(20, 30);
    private final JTextField textField = new JTextField(24);
    private Hannah hannah;

    public PlayerRoles() {
    }

    public void doButton(Hannah hannah) {
        new RunCentralisedMAS();
        new NCT(fu.setAllPlayers());
    }

    @Override
    public void doContinue(Hannah hannah) {
        doButton(hannah);
        hannah.changeState(new DayPanel());
    }

    @Override
    public JTextArea getTextArea() {
        playerRole = fu.createRoles(playerName);
        textAreaOrder.setText("Assigned Roles are as follows\n");
        for (int i = 0; i < playerName.size(); i++) {
            textAreaOrder.append(playerName.get(i) + " is " + playerRole.get(i) + ".\n");
        }
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }
}