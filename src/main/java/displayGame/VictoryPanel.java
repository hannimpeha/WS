package displayGame;

import controllers.ConsolePane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VictoryPanel extends ConsolePane {

    private ActionListener listener;

    public VictoryPanel(ActionListener listener) {
        this.listener = listener;
        box.add(textField);
        box.add(button);
        button.addActionListener(buttonAction);
        contentPane.add(new JScrollPane(textAreaOrder));
        contentPane.add(box, BorderLayout.SOUTH);
        start();
    }

    private void start() {
        System.out.println("Victory!");
    }

}
