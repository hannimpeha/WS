package state;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private Hannah hannah;

    private static JTextField textField = new JTextField();

    public GUI(Hannah hannah) {
        this.hannah = hannah;
    }

    public void init() {
        JFrame frame = new JFrame("Hannah's Finite State Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel context = new JPanel();
        context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));
        frame.getContentPane().add(context);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        context.add(textField);
        context.add(buttons);

        JButton play = new JButton("Continue");
        play.addActionListener(e -> textField.setText(hannah.getState().onDay()));
        frame.setVisible(true);
        frame.setSize(300, 100);
        buttons.add(play);
    }

}
