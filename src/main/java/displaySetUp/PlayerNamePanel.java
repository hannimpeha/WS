package displaySetUp;

import consoles.StreamWriter;
import controllers.ConsolePane;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerNamePanel extends ConsolePane {

    private ActionListener listener;
    private ArrayList<String> playerNames = new ArrayList<String>();
    private JButton btnNames;

    public PlayerNamePanel(ActionListener listener) {
        this.listener = listener;
        displayNorth();
        displaySouth();
    }

    private void displayNorth() {
        textAreaOrder = new JTextArea(20, 30);
        textAreaOrder.setText("Type Players's names");
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
        btnNames = new JButton("Enter");
        btnNames.addActionListener(listener);
        btnNames.setName("Player_Roles");
        box.add(btnNames);
        south.add(box);
    }

    public List<String> getPlayerNames(){
        playerNames.add(textField.getText());
        return playerNames;
    }
}