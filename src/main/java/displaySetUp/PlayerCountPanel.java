package displaySetUp;

import consoles.ConsolePane;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

public class PlayerCountPanel extends ConsolePane {

    private ActionListener listener;
    private JButton button;

    public PlayerCountPanel(ActionListener packageListener,
                            ActionListener listener) {
        super(packageListener);
        this.listener = listener;

    }

    private JButton displayPlayer() {
        button = new JButton("Start");
        button.addActionListener((ActionListener)
                EventHandler.create(ActionListener.class,
                        this,"countPlayers",
                        ""));
        return button;
    }

    private void countPlayers(ActionEvent e) {
        displayPlayer().setActionCommand("Choose Players");
    }
}