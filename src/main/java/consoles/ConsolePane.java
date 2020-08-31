package consoles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public abstract class ConsolePane extends JPanel {

    protected JTextField textField = new JTextField(20);
    protected JTextArea textAreaOrder = new JTextArea(20, 30);
    protected JPanel contentPane = new JPanel(new BorderLayout());
    protected Box box = Box.createHorizontalBox();
    protected JButton button = new JButton("Enter");
    protected ActionListener buttonAction;
    protected ProcExec procExec;

    public ConsolePane() {
        contentPane.add(new JScrollPane(textAreaOrder));
        contentPane.add(box, BorderLayout.SOUTH);
    }

    public Box box() {
        box.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box.add(Box.createHorizontalGlue());
        box.add(textField);
        box.add(Box.createHorizontalStrut(5));
        box.add(button);
        return box;
    }

    public JButton Button() {
        button.setActionCommand("Enter");
        button.addActionListener(buttonAction);
        return button;
    }

    public JTextArea textAreaOrder() {
        textAreaOrder.setEditable(false);
        try {
            OutputStream os = new StreamWriter(textAreaOrder);
            System.setOut(new PrintStream(os, true, "UTF-8"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return textAreaOrder;
    }

    public JTextField textField() {
        return textField;
    }

    public JPanel getContentPane(){
        return contentPane;
    }

}