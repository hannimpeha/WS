package displayMain;

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
    private JButton btnContinueGame;

    public MainPanel(ActionListener listener) {
        this.listener = listener;
        displayCenter();
    }

    private void displayCenter() {
        textField = new JTextField(24);
        textAreaOrder = new JTextArea(20, 30);
        textAreaOrder.setText("Press Button to Continue");
        textAreaOrder.setEditable(false);
        try {
            OutputStream os = new StreamWriter(textAreaOrder);
            System.setOut(new PrintStream(os, true, "UTF-8"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        btnNewGame = new JButton("New Game");
        btnNewGame.addActionListener(listener);
        box.add(textField);
        box.add(btnNewGame);
        contentPane.add(btnNewGame);
        contentPane.add(new JScrollPane(textAreaOrder));
        contentPane.add(box, BorderLayout.SOUTH);
    }
}
