package controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class ConsolePane extends JPanel {

    protected JFrame frame;
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

    public void createFrame(){
        JFrame frame = new JFrame("Hannah's Mafia Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.pack();
        frame.setBounds(500, 20, 400, 430);
        frame.add(contentPane);
    }

    public JPanel getContentPane(){
        return contentPane;
    }
}