package displaySetUp;


import consoles.ConsolePane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PlayerCountPanel extends ConsolePane {

    private ActionListener listener;
    private List<JButton> buttonList = new ArrayList<JButton>();

    public PlayerCountPanel(ActionListener buttonListener,
                            ActionListener listener) {
        this.buttonAction = buttonAction;;
        this.listener = listener;
        box.add(textField);
        box.add(button);
        button.addActionListener(buttonAction);
        contentPane.add(new JScrollPane(textAreaOrder));
        contentPane.add(box, BorderLayout.SOUTH);
    }


    private void displayPlayerButton(int i){
        JButton btnPlayer = new JButton(Integer.toString(i));
        contentPane.add(btnPlayer, "cell 0 "+i+",growx");
        btnPlayer.setName("PlayerCount "+Integer.toString(i));
        btnPlayer.addActionListener(buttonAction);
        buttonList.add(btnPlayer);
    }
}