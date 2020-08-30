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
        textAreaOrder = new JTextArea(20, 20);
        configureJTextAreaForInputOutput(textAreaOrder);
        outputToJTextArea("Game Start");
    }
}
