package displaySetUp;

import consoles.StreamWriter;
import controllers.ConsolePane;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;

public class PlayerRolePanel extends ConsolePane {

    private ActionListener listener;
    private LoadFileUtil fu;
    private JButton btnRoles;

    public PlayerRolePanel(ActionListener listener) {
        this.listener = listener;
        displayNorth();
        displaySouth();
    }


    private void displayNorth() {
        textAreaOrder = new JTextArea(20, 30);
        textAreaOrder.setText("Assigned Roles are as follows");
        textAreaOrder.setEditable(false);
        try {
            OutputStream os = new StreamWriter(textAreaOrder);
            System.setOut(new PrintStream(os, true, "UTF-8"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        north.add(new JScrollPane(textAreaOrder));
    }

    private void displaySouth() {
        box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        textField = new JTextField(24);
        box.add(textField);
        btnRoles = new JButton("Enter");
        btnRoles.addActionListener(listener);
        btnRoles.setName("Game_Start");
        box.add(btnRoles);
        south.add(box);
    }

}