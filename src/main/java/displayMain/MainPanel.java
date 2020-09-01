package displayMain;

import controllers.ConsolePane;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainPanel extends ConsolePane {

    private ActionListener listener;
    private JButton btnNewGame;
    private JButton btnContinueGame;

    public MainPanel(ActionListener buttonAction, ActionListener listener) {
        this.buttonAction = buttonAction;
        this.listener = listener;
        displayCenter();
    }

    private void displayCenter() {
        btnNewGame = new JButton("New Game");
        contentPane.add(btnNewGame);
        btnNewGame.addActionListener(listener);
    }
}
