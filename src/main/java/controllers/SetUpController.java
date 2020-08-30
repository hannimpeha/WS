package controllers;

import consoles.ConsolePane;
import consoles.ProcExec;
import displaySetUp.PlayerCountPanel;
import displaySetUp.PlayerNamePanel;
import displaySetUp.PlayerRolePanel;
import util.LoadFileUtil;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetUpController implements ActionListener {

    private JFrame frame;
    private PlayerCountPanel pcp;
    private PlayerNamePanel pnp;
    private PlayerRolePanel prp;
    private JButton playerCount;
    private ActionListener listener;
    private LoadFileUtil fu;
    private int playerTotal;

    public SetUpController(JFrame frame, ActionListener listener) {
        this.frame = frame;
        this.listener = listener;
        ProcExec instance = new ProcExec(this);
        EventQueue.invokeLater(instance);
    }

    public void start() {
        pcp = new PlayerCountPanel(this, listener);
        pnp = new PlayerNamePanel(this, listener);
        prp = new PlayerRolePanel(this, listener);
        playerCount = pcp.getContentPane();
        playerTotal = 7;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String name = source.toString();
        switch(name) {
            case "Game":
                switchPanel(playerCount);
//            case "PlayerName":
//                switchPanel(prp);
        }
    }

    private void switchPanel(JButton button) {
        frame.getContentPane().setVisible(false);
        frame.setContentPane(button);
        frame.getContentPane().setVisible(true);
    }

//    public List<String> getPlayerNames(){
//        return pnp.getPlayerNames();
//    }
//
//    public List<String> getRoles(){
//        return prp.getRolesSelected();
//    }
}
