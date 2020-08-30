package controllers;
import consoles.*;
import util.LoadFileUtil;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller implements DocumentListener {

    private JFrame frame;
    private JButton button;
    private JTextField textField;
    private MainController mc;
    private SetUpController suc;
    private GameController gc;
    private LoadFileUtil fu;

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
        //mc = new MainController(frame, this);
        suc = new SetUpController(frame, this);
        //gc = new GameController(frame, this);
        suc.start();
    }

    public void createFrame() {
        JFrame frame = new JFrame("Hannah's Mafia Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new ConsolePane().display(button));
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

    @Override
    public void insertUpdate(DocumentEvent e) {
        changedUpdate(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        changedUpdate(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        SwingUtilities.invokeLater(()->{
            new ChangeEvent(textField);
        });
    }
}