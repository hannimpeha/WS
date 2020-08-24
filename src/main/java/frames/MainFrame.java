package frames;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private ActionListener globalListener;
    private JButton btnNewGame;
    private JButton btnContinueGame;
    private JButton btnAbout;
    private JButton btnRules;

    public MainFrame(ActionListener globalListener){
        this.globalListener = globalListener;
        System.out.println("Press Day to start");
    }

    public void display() {
        btnNewGame = new JButton("New Game");
        btnNewGame.addActionListener(globalListener);
        btnContinueGame = new JButton("Continue");
        btnContinueGame.addActionListener(globalListener);
        btnAbout = new JButton("About");
        btnAbout.addActionListener(globalListener);
        btnRules = new JButton("Rules");
        btnRules.addActionListener(globalListener);
    }
}
