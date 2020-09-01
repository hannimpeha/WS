package panels;

import consoles.StreamWriter;
import controllers.ConsolePane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MainPanel extends ConsolePane {

    private ActionListener listener;
    private JButton btnNewGame;

    public MainPanel(ActionListener listener) {
        this.listener = listener;
        displayNorth();
        displaySouth();
    }

    private void displayNorth() {
        textAreaOrder = new JTextArea(20, 30);
        textAreaOrder.setText("Press Button to Continue");
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
        btnNewGame = new JButton("Enter");
        btnNewGame.addActionListener(listener);
        btnNewGame.setName("Player_Names");
        box.add(btnNewGame);
        south.add(box);
    }
}
