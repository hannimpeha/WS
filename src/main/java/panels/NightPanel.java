package panels;

import consoles.StreamWriter;
import controllers.ConsolePane;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class NightPanel extends ConsolePane {

    private ActionListener listener;
    private JButton btnNight;
    private ArrayList<JButton> playerButtonList = new ArrayList<JButton>();

    public NightPanel(ActionListener listener) {
        this.listener = listener;
        displayNorth();
        displaySouth();
    }

    public void displayNorth() {
        textAreaOrder = new JTextArea(20, 30);
        textAreaOrder.setText("This is Night");
        textAreaOrder.setEditable(false);
        try {
            OutputStream os = new StreamWriter(textAreaOrder);
            System.setOut(new PrintStream(os, true, "UTF-8"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        north.add(new JScrollPane(textAreaOrder));
    }

    public void displaySouth() {
        box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        textField = new JTextField(24);
        box.add(textField);
        btnNight = new JButton("Enter");
        btnNight.addActionListener(listener);
        btnNight.setName("Check_Victory");
        box.add(btnNight);
        south.add(box);
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