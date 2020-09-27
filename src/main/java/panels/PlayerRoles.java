package panels;

import jason.NCT;
import jason.infra.centralised.RunCentralisedMAS;
import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PlayerRoles {

    private LoadFileUtil fu = new LoadFileUtil();
    private List<Player> playerInfo = fu.loadPlayer();

    public PlayerRoles() {
    }

    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 40);
        textAreaOrder.setText("Assigned Roles are as follows\n");
        for(int i=0; i<playerInfo.size(); i++) {
            textAreaOrder.setText(
                    "Player "+playerInfo.get(i).getName()+" is "+
                            playerInfo.get(i).getRole()+".\n");
        }
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }

    public JButton createButton() {
        final JButton button = new JButton("Role");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RunCentralisedMAS();
                new NCT(playerInfo);
                fu.saveGame(playerInfo);
            }

        });
        return button;
    }

}
