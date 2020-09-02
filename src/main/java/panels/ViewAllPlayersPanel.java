package panels;

import consoles.StreamWriter;
import controllers.ConsolePane;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class ViewAllPlayersPanel extends ConsolePane {

    private ActionListener listener;
    private JButton btnContinue;

    public ViewAllPlayersPanel(ActionListener listener) {
        this.listener = listener;
        displayNorth();
        displaySouth();
    }

    public void displayNorth() {
        textAreaOrder = new JTextArea(20, 30);
        textAreaOrder.setText("This is Day");
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
        box.setBorder(BorderFactory.createEmptyBorder(
                5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        textField = new JTextField(24);
        box.add(textField);
        btnContinue = new JButton("Enter");
        btnContinue.addActionListener(listener);
        btnContinue.setName("Night_Start");
        box.add(btnContinue);
        south.add(box);
    }


}
