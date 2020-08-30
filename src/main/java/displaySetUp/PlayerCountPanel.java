package displaySetUp;

import consoles.ConsolePane;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PlayerCountPanel extends ConsolePane {

    private ActionListener listener;
    private JTextArea textArea;
    private JTextArea textAreaOrder;

    public PlayerCountPanel(ActionListener packageListener,
                            ActionListener listener) {
        super(packageListener);
        this.listener = listener;
        setName("PlayerCount Panel");
        displayPlayer();
    }

    private void displayPlayer() {
        outputToJTextArea("Game Start");
    }
}