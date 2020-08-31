package controllers;

import displaySetUp.PlayerNamePanel;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller implements ActionListener{

    public JFrame frame;
    public SetUpController suc;
    public GameController gc;
    public LoadFileUtil fu;

    public Controller() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                createFrame();
            }
        });
    }

    public void run() {
        suc = new SetUpController(frame, this);
        gc = new GameController(frame, this);
        fu = new LoadFileUtil();
        suc.start();
    }

    public void createFrame() {
        JFrame frame = new JFrame("Hannah's Mafia Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();
    }

    private void test() {
        List<String> names = new ArrayList<String>(Arrays.asList(
                "Pierce","Mahsa","Christilyn","Elvin","Ronelle","Harry",
                "Ron","Hermione","Tom Riddle","Albus D","Captain Jack","Sparkey Sparkey Boom Man"));
        List<String> roles = new ArrayList<>(Arrays.asList(
                "Doctor","Detective","Mafia: Hitman","Town","Bodyguard","Survivor",
                "Mafia: Barman","Lyncher","Mafia- GodFather","Vigilante","Prostitute","Mafia: Goon"));

        fu.newFile(names, roles);
        gc.start(fu.getPlayerInfo());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        String name = source.getName();
        switch(name){
            case"NewGame_MainPanel":
                suc.start();
                break;
            case"ContinueGame_MainPanel":
                fu.loadFile();
                gc.start(fu.getPlayerInfo());
                break;
            case"Home":
                //mc.start();
                break;
            case"Continue_RoleSelectionPanel":
                //fu.newFile(suc.getPlayerNames(),suc.getRoles());
                gc.start(fu.getPlayerInfo());
                break;
            /** initializes a test game, skipping the set up phase */
            case"Testing_MainPanel":
                test();
                break;
            default:break;
        }
    }
}