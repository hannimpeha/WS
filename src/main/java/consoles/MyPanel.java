package consoles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class MyPanel {
    protected ActionListener packageListener;
    protected JPanel contentPane = new JPanel();
    protected MyTextArea north;
    protected MyTextArea south;

    public MyPanel() {
        north = new MyTextArea("");
        contentPane.add(north.displayOrder(), BorderLayout.NORTH);
        south = new MyTextArea("");
        contentPane.add(south.displayListener(), BorderLayout.SOUTH);
    }

    public JPanel getContentPane() {
        return contentPane;
    }
}
