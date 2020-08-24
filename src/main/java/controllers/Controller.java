package controllers;

import util.LoadFileUtil;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;
import javax.swing.*;

public class Controller implements ActionListener, KeyListener {

    private JFrame frame;
    private LoadFileUtil fu;
    private SetUpController suc;
    private GameController gc;
    private MainController mc;

    public Controller() {
        createFrame();
    }

    public void run() {
        suc = new SetUpController(frame, this);
        gc = new GameController(frame, this);
        mc = new MainController(frame,  this);
        fu = new LoadFileUtil();
    }

    private void createFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.addKeyListener(this);
        //frame.setFocusable(true);
        //frame.setFocusTraversalKeysEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Type Home/Day/Night to Start Mafia Game");
        JButton source = (JButton)e.getSource();
        String name = source.getName();
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
    public void keyTyped(KeyEvent e) {
        // String name = KeyEvent.getKeyText(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void waitForSpace() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        KeyEventDispatcher dispatcher = new KeyEventDispatcher() {
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE)
                    latch.countDown();
                return false;
            }
        };
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(dispatcher);
        latch.await();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(dispatcher);
    }

}
