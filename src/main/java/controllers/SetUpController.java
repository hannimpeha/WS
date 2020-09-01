package controllers;

import displaySetUp.PlayerCountPanel;
import displaySetUp.PlayerNamePanel;
import displaySetUp.PlayerRolePanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetUpController implements ActionListener {

    private JFrame frame;
    private PlayerCountPanel pcp;
    private PlayerNamePanel pnp;
    private PlayerRolePanel prp;
    private JPanel playerCount;
    private JPanel playerName;
    private JPanel playerRole;
    private ActionListener listener;
    private int playerTotal;

    public SetUpController(JFrame frame, ActionListener listener) {
        this.frame = frame;
        this.listener = listener;
        //ProcExec instance = new ProcExec(this);
        //EventQueue.invokeLater(instance);
    }

    public void start() {
        pcp = new PlayerCountPanel(this);
        pnp = new PlayerNamePanel(this);
        prp = new PlayerRolePanel(this);
        playerCount = pcp.getContentPane();
        playerName = pnp.getContentPane();
        playerRole = prp.getContentPane();
        playerTotal = 7;
        switchPanel(playerCount);
    }

    private void switchPanel(JPanel panel) {
        JFrame frame = new JFrame("Hannah's Mafia Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();
        frame.setBounds(500, 20, 400, 400);
        frame.getContentPane().setVisible(false);
        frame.setContentPane(panel);
        frame.getContentPane().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String name = source.getName();

        if (name.contains("RoleButton")) {
            onRoleButtonClick(source);
        } else {
            switch (name) {
                case "Continue_PlayerCount":
                    //Creates a list of player input fields for the amount of players selected
                    pnp.displayCenter(playerTotal);
                    switchPanel(playerName);
                    break;
                case "Continue_PlayerName":
                    switchPanel(playerRole);
                    //prp.getPlayersLeft().setText(String.valueOf(pnp.getPlayerNames().size()));
                    int total = pnp.getPlayerNames().size();
                    if (total < 6) {
                    //    prp.getRecomdedMafia().setText("1 Mafia Player Recomeded");
                    } else if (total < 9) {
                    //    prp.getRecomdedMafia().setText("2 Mafia Player Recomeded");
                    } else if (total < 12) {
                    //    prp.getRecomdedMafia().setText("3 Mafia Player Recomeded");
                    } else if (total == 12) {
                    //    prp.getRecomdedMafia().setText("4 Mafia Player Recomeded");
                    }
                    break;
                case "Reset_RoleSelection":
                    //resetSelections();
                    break;
                case "AssignTownies_RoleSelection":
                    //assignRestAsTownies(source);
                    break;
                default:
                    //If the button that was pressed was in the PlayerCountPanel
                    if (name.contains("PlayerCount ")) {
                        playerTotal = Integer.parseInt(name.substring(12, name.length()));//Receive the int value of the button that was pressed
                    //    pcp.changeButtonSelected(playerTotal);//Sets the pressed button to the selected color and all the other buttons to default colors
                    }
                    break;
            }
        }
    }

    private void onRoleButtonClick(JButton source) {
        prp.addRole(source.getText());
        final int rolesSelectedSize = prp.getRolesSelected().size();
        final int playerNamesSize = pnp.getPlayerNames().size();
        source.setEnabled(false);
    }
}

//    public List<String> getPlayerNames(){
//        return pnp.getPlayerNames();
//    }
//
//    public List<String> getRoles(){
//        return prp.getRolesSelected();
//    }
