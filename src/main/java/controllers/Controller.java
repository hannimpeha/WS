package controllers;

import util.LoadFileUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller extends ConsolePane implements ActionListener {

    public JFrame frame;
    public MainController mc;
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
            }
        });
    }

    public void run() {
        mc = new MainController(frame, this);
        gc = new GameController(frame, this);
        fu = new LoadFileUtil();
        mc.start();
    }

    private void test() {
        List<String> names = new ArrayList<String>(Arrays.asList(
                "Pierce", "Mahsa", "Christilyn", "Elvin", "Ronelle", "Harry",
                "Ron", "Hermione", "Tom Riddle", "Albus D", "Captain Jack", "Sparkey Sparkey Boom Man"));
        List<String> roles = new ArrayList<>(Arrays.asList(
                "Doctor", "Detective", "Mafia: Hitman", "Town", "Bodyguard", "Survivor",
                "Mafia: Barman", "Lyncher", "Mafia- GodFather", "Vigilante", "Prostitute", "Mafia: Goon"));
        fu.newFile(names);
        gc.start(fu.getPlayerInfo());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        String name = source.getName();
        switch(name) {
            case "Game_Start":
                test();
                break;
        }
    }
}