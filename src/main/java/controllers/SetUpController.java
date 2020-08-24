package controllers;

import frames.PlayerCountFrame;
import frames.PlayerNameFrame;
import frames.RoleSelectionFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SetUpController implements ActionListener {

    private ActionListener globalListener;
    private JFrame frame;

    private PlayerCountFrame pcf;
    private PlayerNameFrame pnf;
    private RoleSelectionFrame rsf;

    private Container panelCount;
    private Container panelName;
    private Container panelRole;

    private int playerTotal;

    public SetUpController(JFrame frame, ActionListener globalListener) {
        this.frame = frame;
        this.globalListener = globalListener;
    }

    public void start() {

        pcf = new PlayerCountFrame(globalListener);
        pnf = new PlayerNameFrame(this, globalListener);
        rsf = new RoleSelectionFrame(this, globalListener);

        panelCount = pcf.getContentPane();
        panelName = pnf.getContentPane();
        panelRole = rsf.getContentPane();

        playerTotal = 3;

        switchPanel((JPanel) panelCount);
    }

    private void switchPanel(JPanel panel){
        System.out.println("SWITCHING: "+panel.getName());
        frame.getContentPane().setVisible(false);
        frame.setContentPane(panel);
        frame.getContentPane().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String name = source.getName();
        switch (name) {
            case "Continue_PlayerCount":
                pnf.displayCenter(playerTotal);
                switchPanel((JPanel) panelName);
                break;
        }
    }
    public List<String> getPlayerNames() {
        return pnf.getPlayerNames();
    }

    public List<String> getRoles() {
        return rsf.getRoles();
    }
}
