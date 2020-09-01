package panels;

import consoles.StreamWriter;
import controllers.ConsolePane;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class VictoryPanel extends ConsolePane {

    private ActionListener listener;
    private JButton btnVictory;

    public VictoryPanel(ActionListener listener) {
        this.listener = listener;
        displayNorth();
        displaySouth();
    }

    private void displayNorth() {
        textAreaOrder = new JTextArea(20, 30);
        textAreaOrder.setText("Check to see if there is winner");
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
        btnVictory = new JButton("Enter");
        btnVictory.addActionListener(listener);
        btnVictory.setName("Victory");
        box.add(btnVictory);
        south.add(box);
    }

}
