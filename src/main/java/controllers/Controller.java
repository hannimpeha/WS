package controllers;

import consoles.*;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller implements ActionListener {

    private JFrame frame;
    private MainController mc;
    private SetUpController suc;
    private GameController gc;
    private LoadFileUtil fu;

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
        mc = new MainController(frame, this);
        suc = new SetUpController(frame, this);
        gc = new GameController(frame, this);
        suc.start();
    }

    public void createFrame() {
        JFrame frame = new JFrame("Hannah's Mafia Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new ConsolePane(this));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ConsolePane source = (ConsolePane) e.getSource();
        String name = source.getName();
        switch (name) {
            case "NewGame_MainPanel":
                suc.start();
                break;
            case "ContinueGame_MainPanel":
                fu.loadFile();
                gc.start(fu.getPlayerInfo());
                break;
            case "Continue_RoleSelectionPanel":
                //fu.newFile(suc.getPlayerNames(), suc.getRoles());
                gc.start(fu.getPlayerInfo());
                break;
            case "Home":
                mc.start();
                break;
            case "Testing":
                test();
                break;
        }
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

}
