package frames;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class PlayerNameFrame extends JFrame implements KeyListener {

    private ActionListener globalListener;
    private JFrame frame;

    public PlayerNameFrame(ActionListener globalListener){
        this.globalListener = globalListener;
        addKeyListener((KeyListener) globalListener);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public List<String> getPlayerNames() {
        List<String> names = new ArrayList<>();
        if(frame.getContentPane().equals("")||frame.getContentPane()==null){
            names.add(frame.getName());
        }else{
            names.add(frame.getContentPane().getName());
        }
        return names;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(KeyEvent.getKeyText(e.getKeyCode())=="yes"){}
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
