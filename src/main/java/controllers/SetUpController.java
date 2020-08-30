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
    private ActionListener listener;
    private LoadFileUtil fu;
    private int playerTotal;

    public SetUpController(JFrame frame, ActionListener listener) {
        this.frame = frame;
        this.listener = listener;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                start();
            }
        });
    }

    public void start() {
        pcp = new PlayerCountPanel(this, listener);
        pnp = new PlayerNamePanel(this, listener);
        prp = new PlayerRolePanel(this, listener);
        playerTotal = 7;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProcExec source = (ProcExec) e.getSource();
        //source.outputToJTextArea("Type Players' names.");
        String name = source.toString();
        switch(name) {
            case "PlayerCount Panel":
                playerTotal = pnp.getPlayerNames().size();
                switchPanel(pnp);
            case "PlayerName Panel":
                switchPanel(prp);
        }
    }

    private void switchPanel(JPanel panel) {
        frame.getContentPane().setVisible(false);
        frame.setContentPane(panel);
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
