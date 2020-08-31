package controllers;
import consoles.*;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    public JFrame frame;
    public ActionListener buttonAction;
    public ProcExec procExec;
    public JTextField textField;
    public MainController mc;
    public SetUpController suc;
    public GameController gc;
    public LoadFileUtil fu;

    public ActionListener textAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (textField.getText()=="game"){
                System.out.println("Great");
            }
        }
    };

    public Controller() {
//        ProcExec instance = new ProcExec(this);
//        EventQueue.invokeLater(instance);
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
        mc = new MainController(frame, buttonAction);
        suc = new SetUpController(frame, buttonAction);
        gc = new GameController(frame, buttonAction);
        suc.start();
    }

    public void createFrame() {
        JFrame frame = new JFrame("Hannah's Mafia Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new ConsolePane(textAction).display());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
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