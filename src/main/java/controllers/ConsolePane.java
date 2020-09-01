package controllers;

import consoles.StreamWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public abstract class ConsolePane extends JPanel {

    protected JTextField textField;
    protected JTextArea textAreaOrder;
    protected JPanel contentPane = new JPanel();
    protected Box box;
    protected JButton button;
    protected ActionListener listener;

    public ConsolePane() {
        textField = new JTextField(24);
        textAreaOrder = new JTextArea(20, 30);
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
        button = new JButton("Enter");
        button.setActionCommand("Enter");
        button.addActionListener(listener);
        box.add(textField);
        box.add(button);
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
        button.addActionListener(listener);
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