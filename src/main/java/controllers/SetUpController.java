package controllers;

import frames.PlayerCountFrame;
import frames.PlayerNameFrame;
import frames.RoleSelectionFrame;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.keyboard.NativeKeyEvent;
import playerInfo.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SetUpController implements ActionListener {

    private ActionListener globalListener;
    private JFrame frame;
    private ArrayList<JTextField> textFields = new ArrayList<>();
    private int playerTotal;
    private PlayerCountFrame pcf;
    private PlayerNameFrame pnf;
    private RoleSelectionFrame rsf;

    public SetUpController(JFrame frame, ActionListener globalListener) {
        this.frame = frame;
        this.globalListener = globalListener;
    }

    public void start() {

        pcf = new PlayerCountFrame(globalListener);
        pnf = new PlayerNameFrame(globalListener);
        rsf = new RoleSelectionFrame(globalListener);
        playerTotal = 3;

    }


    public void displayPlayerCenter(int playerTotal) {
        for(int i=0; i<playerTotal; i++) {
            textFields.add(new JTextField());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame source = (JFrame) e.getSource();
        String name = source.getName();
        switch(name) {
            case"Continue_PlayerCount":
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
