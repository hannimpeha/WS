package panels;

import controllers.ConsolePane;
import jason.NCT;
import jason.infra.centralised.RunCentralisedMAS;
import stateMachine.Hannah;
import util.LoadFileUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class PlayerRoles extends ConsolePane {

    private List<String> playerName =
            Arrays.asList("hyo", "ji", "yoo", "mi", "vi", "se", "ari");
    private LoadFileUtil fu = new LoadFileUtil(playerName);
    private List<String> playerRole;

    public PlayerRoles(Hannah hannah) {
        super(hannah);
        createPanel();
        doButton();
    }

    public void createPanel() {
        playerRole = fu.createRoles(playerName);
        getTextAreaOrder().setText("Assigned Roles are as follows\n");
        for(int i=0; i<playerName.size(); i++) {
            getTextAreaOrder().append(playerName.get(i)+" is "+playerRole.get(i)+".\n");
        }
        getTextAreaOrder().setEditable(false);
    }

    public void doButton() {
        getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RunCentralisedMAS();
                new NCT(fu.setAllPlayers());
            }
        });
    }

}