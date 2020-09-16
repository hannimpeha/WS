package controllers;

import javax.swing.*;
import java.awt.*;

public class ConsolePane extends JPanel {

    private static JPanel contentPane = new JPanel();
    private static JPanel north = new JPanel();
    private static JPanel south = new JPanel();
    private static Hannah hannah;

    public ConsolePane(Hannah hannah) {
        this.hannah = hannah;
        displayNorth();
        displaySouth();
    }

    public void initFrame() {
        JFrame frame = new JFrame("Hannah's Mafia Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 20, 400, 450);
        frame.setLocationRelativeTo(null);
        frame.add(north, BorderLayout.CENTER);
        frame.add(south, BorderLayout.PAGE_END);
        frame.pack();
        frame.setVisible(true);
    }

    public void displayNorth() {
        north = hannah.getState().onContinue();
        contentPane.add(new JScrollPane(north));
    }

    public void displaySouth() {
        south = hannah.getState().onContinue();
        contentPane.add(south);
    }

    public static JPanel getContentPane(){ return contentPane; }
    public static JPanel getNorthPane() { return north; }
    public static JPanel getSouthPane() { return south; }

}
