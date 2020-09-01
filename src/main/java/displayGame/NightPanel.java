package displayGame;

import controllers.ConsolePane;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NightPanel extends ConsolePane {

    private ActionListener listener;
    private ArrayList<JButton> playerButtonList = new ArrayList<JButton>();

    public NightPanel(ActionListener listener) {
        this.listener = listener;
        box.add(textField);
        box.add(button);
        button.addActionListener(listener);
        contentPane.add(new JScrollPane(textAreaOrder));
        contentPane.add(box, BorderLayout.SOUTH);
    }

    private void start() {
        System.out.println("Press Night to Continue.");
    }

    public void displayPlayerButton(String name, int position) {

        JButton btnPlayer = new JButton(name);
        btnPlayer.setName("Day_" + Integer.toString(position));
        contentPane.add(btnPlayer, "cell 0 " + position + ",growx");
        btnPlayer.addActionListener(listener);
        if (btnPlayer.getFont().getSize() < 25) btnPlayer.setBorder(new EmptyBorder(10, 5, 10, 5));
        playerButtonList.add(btnPlayer);
    }

}