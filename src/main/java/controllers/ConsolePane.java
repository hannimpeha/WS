package controllers;

import javax.swing.*;
import java.awt.*;

public abstract class ConsolePane {

    protected JPanel contentPane = new JPanel();
    protected JPanel north = new JPanel();
    protected JPanel south = new JPanel();
    protected Box box = Box.createHorizontalBox();
    protected JTextField textField = new JTextField(24);
    //protected JTextArea textAreaOrder = new JTextArea(20, 30);
    protected JButton button = new JButton("Enter");
    protected Hannah hannah;

    public ConsolePane(Hannah hannah) {
        this.hannah = hannah;
        displayNorth();
        displaySouth();
    }

    public void initFrame() {
        JFrame frame = new JFrame("Hannah's Mafia Game");;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 20, 400, 450);
        frame.setLocationRelativeTo(null);
        frame.add(north, BorderLayout.CENTER);
        frame.add(south, BorderLayout.PAGE_END);
        frame.pack();
        frame.setVisible(true);
    }

    private void displayNorth() {
        //textAreaOrder = hannah.getState().onContinue();
        button.addActionListener(e->hannah.getState().doContinue(hannah));
        north.add(new JScrollPane(hannah.getState().getTextArea()));
        contentPane.add(north);
    }

    private void displaySouth() {
        box.setBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        //box.add(textAreaOrder);
        box.add(textField);
        button.addActionListener(e->hannah.getState().doContinue(hannah));
        box.add(button);
        south.add(box);
        contentPane.add(south);
    }

}

