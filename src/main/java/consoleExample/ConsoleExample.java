package consoleExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.InputStream;

public class ConsoleExample extends JFrame implements ActionListener {

    private InputStream input;
    private JTextArea textArea;
    private JFrame frame;

    public ConsoleExample() {
        //this.input = input;
        //System.out.println(input.read());
        JTextArea textArea = new JTextArea(5,100);
        //textArea.setKeymap((Keymap) System.in);
        //addKeyBinding(textArea, KeyEvent.VK_1, "1", (actionEvent)->{System.out.println("hello hannah");});
        textArea.setText("please type something");
        textArea.setSize(this.getWidth(), this.getHeight());
        setLayout(new FlowLayout());
        Container container = getContentPane();
        container.add(textArea);
    }

    public static void addKeyBinding(JTextArea textArea, int keyCode, String id, ActionListener actionListener) {
        InputMap im = textArea.getInputMap(JTextArea.WHEN_FOCUSED);
        ActionMap ap = textArea.getActionMap();
        im.put(KeyStroke.getKeyStroke(keyCode, 0, false), id);
        ap.put(id, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionListener.actionPerformed(e);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
