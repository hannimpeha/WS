package controllers;

import consoles.ConsolePane;
import consoles.ProcExec;
import displaySetUp.PlayerCountPanel;
import displaySetUp.PlayerNamePanel;
import displaySetUp.PlayerRolePanel;
import util.LoadFileUtil;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetUpController implements DocumentListener {

    private JFrame frame;
    private PlayerCountPanel pcp;
    private PlayerNamePanel pnp;
    private PlayerRolePanel prp;
    private JButton playerCount;
    private DocumentListener listener;
    private LoadFileUtil fu;
    private int playerTotal;

    public SetUpController(JFrame frame, DocumentListener listener) {
        this.frame = frame;
        this.listener = listener;
        //ProcExec instance = new ProcExec(this);
        //sEventQueue.invokeLater(instance);
    }

    public void start() {
        pcp = new PlayerCountPanel(this, listener);
        pnp = new PlayerNamePanel(this, listener);
        prp = new PlayerRolePanel(this, listener);
        //playerCount = pcp.getContentPane();
        playerTotal = 7;
    }


    private void switchPanel(JButton button) {
        frame.add(new ConsolePane().display(button));
    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

//    public List<String> getPlayerNames(){
//        return pnp.getPlayerNames();
//    }
//
//    public List<String> getRoles(){
//        return prp.getRolesSelected();
//    }
}
