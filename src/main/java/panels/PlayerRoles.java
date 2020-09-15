package panels;

import jason.Agents;
import jason.NCT;
import jason.infra.centralised.RunCentralisedMAS;
import org.neo4j.graphdb.Node;
import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

public class PlayerRoles  {

    private LoadFileUtil fu = new LoadFileUtil();
    private List<Player> playerInfo;
    private List<String> playerName;
    private List<String> playerRole;


    public PlayerRoles() {
        createPanel();
        createButton();
    }


    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 30);
        playerName = Arrays.asList("hyo", "ji", "yoo",
                "mi", "vi", "se", "ari");
        fu.createRoles(playerName);
        textAreaOrder.setText("Assigned Roles are as follows\n");
        for(int i=0; i<playerName.size(); i++) {
            textAreaOrder.append(playerName.get(i)+" is "+playerRole.get(i)+".\n");
        }
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }

    public Box createButton() {
        final Box box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        final JTextField textField = new JTextField(24);
        box.add(textField);
        final JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new PlayerRolesActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RunCentralisedMAS();
                new NCT(playerInfo = fu.setAllPlayers());
                fu.saveGame(playerInfo);
            }

            @Override
            public List<Player> setAllPlayers() {
                return fu.setAllPlayers();
            }

            @Override
            public List<Node> setAllNodes() {
                return fu.setAllNodes();
            }

            @Override
            public List<Agents> setAllAgents() {
                return fu.setAllAgents();
            }

            @Override
            public void saveGameRole(List<Player> playerInfo) {
                fu.saveGame(playerInfo);
            }

        });
        box.add(sendButton);
        return box;
    }

}


