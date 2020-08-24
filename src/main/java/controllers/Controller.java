package controllers;

import util.LoadFileUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import javax.swing.JFrame;

public class Controller implements ActionListener, KeyListener {

    private JFrame frame;
    private LoadFileUtil fu;
    private SetUpController suc;
    private GameController gc;
    private MainController mc;
    private KeyListener listener;
    private ActionEvent event;

    public Controller() {
        System.out.println("start");
        frame = new JFrame();
        frame.addKeyListener((KeyListener) event);
        frame.setFocusable(true);
        frame.setFocusTraversalKeysEnabled(false);
    }

    public void run() {
        suc = new SetUpController(frame, this);
        gc = new GameController(frame, this);
        mc = new MainController(frame, this);
        fu = new LoadFileUtil();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        String name = KeyEvent.getKeyText(e.getKeyCode());
        switch(name) {
            case "Day":
                suc.start();
                fu.newFile(suc.getPlayerNames(), suc.getRoles());
            case "Night":
                fu.loadFile();
                try {
                    gc.start(fu.getPlayerInfo());
                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();
                }
            case "Home":
                mc.start();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

}
