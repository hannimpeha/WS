package controllers;

import consoles.ConsolePane;
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
    private ConsolePane pcp;
    private ConsolePane pnp;
    private ConsolePane prp;
    private ActionListener listener;
    private LoadFileUtil fu;

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ConsolePane source = (ConsolePane) e.getSource();
        source.outputToJTextArea("Type Players' names.");
        String name = source.getInputFromJTextArea();
        switch(name) {
            case "PlayerCount Panel":
                switchPanel(pcp);
            case "PlayerName Panel":
                switchPanel(pnp);
            case "PlayerRole Panel":
                switchPanel(prp);
        }
    }

    private void switchPanel(ConsolePane cp) {
        frame.getContentPane().setVisible(false);
        frame.setContentPane(cp);
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
