package controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class ConsolePane extends JPanel {

    protected JTextField textField;
    protected JTextArea textAreaOrder;
    protected JPanel contentPane = new JPanel();
    protected JPanel north;
    protected JPanel south;
    protected Box box;
    protected JButton button;
    protected ActionListener listener;

    public ConsolePane() {
        north = new JPanel();
        contentPane.add(north, BorderLayout.NORTH);
        south = new JPanel();
        contentPane.add(south, BorderLayout.SOUTH);
    }

    public JPanel getContentPane(){
        return contentPane;
    }

}