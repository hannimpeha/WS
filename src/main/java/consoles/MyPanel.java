package consoles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class MyPanel {
    private ActionListener packageListener;
    private JPanel contentPane = new JPanel();
    private JPanel north;
    private JPanel south;

    public MyPanel() {
        contentPane.setLayout(new BorderLayout(0,0));
        north = new JPanel();
        contentPane.add(north, BorderLayout.NORTH);
        south = new JPanel();
        contentPane.add(south, BorderLayout.SOUTH);
    }

    public JPanel getContentPane() {
        return contentPane;
    }
}
