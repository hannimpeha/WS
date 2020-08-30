package displaySetUp;

import consoles.ConsolePane;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

public class PlayerCountPanel extends ConsolePane {

    private ActionListener listener;
    private JButton button;

    public PlayerCountPanel(ActionListener packageListener,
                            ActionListener listener) {
        super();
        this.listener = listener;

    }

    private JButton countPlayer() {
        button = new JButton("Start");
        button.addActionListener((ActionListener)
                EventHandler.create(ActionListener.class,
                        this,"countPlayers",
                        ""));
        return button;
    }
}