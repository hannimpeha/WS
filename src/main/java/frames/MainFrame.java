package frames;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame implements KeyListener {

    private ActionListener globalListener;
    private JFrame frameContinue;
    private JFrame frameHome;

    public MainFrame(ActionListener globalListener){
        this.globalListener = globalListener;
        addKeyListener((KeyListener) globalListener);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(KeyEvent.getKeyText(e.getKeyCode())=="yes") {

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

