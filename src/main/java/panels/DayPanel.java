package panels;

import consoles.StreamWriter;
import controllers.ConsolePane;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class DayPanel extends ConsolePane {

    private ActionListener listener;
    private JButton btnDays;

    public DayPanel(ActionListener listener) {
        this.listener = listener;
        displayNorth();
        displaySouth();
    }

    private void displayNorth() {
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

    private void displaySouth() {
        box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        textField = new JTextField(24);
        box.add(textField);
        btnDays = new JButton("Enter");
        btnDays.addActionListener(listener);
        btnDays.setName("Night_Start");
        box.add(btnDays);
        south.add(box);
    }

}