package displayGame;

import consoles.ConsolePane;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DayPanel extends ConsolePane {

    private ActionListener listener;
    private ArrayList<JButton> playerButtonList = new ArrayList<JButton>();

    public DayPanel(ActionListener buttonListener,
                    ActionListener listener) {
        this.buttonAction = buttonAction;;
        this.listener = listener;
        box.add(textField);
        box.add(button);
        button.addActionListener(buttonAction);
        contentPane.add(new JScrollPane(textAreaOrder));
        contentPane.add(box, BorderLayout.SOUTH);
    }

    private void start() {
        System.out.println("Day");
    }

    public void displayPlayerButton(String name, int position) {

        JButton btnPlayer = new JButton(name);
        btnPlayer.setName("Day_" + Integer.toString(position));
        contentPane.add(btnPlayer, "cell 0 " + position + ",growx");
        btnPlayer.addActionListener(buttonAction);
        if (btnPlayer.getFont().getSize() < 25) btnPlayer.setBorder(new EmptyBorder(10, 5, 10, 5));
        playerButtonList.add(btnPlayer);
    }

}