package consoles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.EventHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class ConsolePane extends JPanel {

    public final JTextField textField = new JTextField(20);
    public final JTextArea textAreaOrder = new JTextArea(20, 30);
    public ActionListener listener;
    public ProcExec procExec;
    public JButton button;
    public ActionListener textAction;
    public ActionListener buttonAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(textField.getText()=="game") {
                textAreaOrder.setText("Choose players");
            }
        }
    };

    public ConsolePane(ActionListener textAction) {
        this.textAction = textAction;
    }

    public JComponent display() {
        textAreaOrder.setText("Game or Exit");
        try {
            OutputStream os = new StreamWriter(textAreaOrder);
            System.setOut(new PrintStream(os, true, "UTF-8"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Box box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box.add(Box.createHorizontalGlue());
        box.add(textField);
        box.add(Box.createHorizontalStrut(5));
//        box.add(new JButton(new AbstractAction("Enter") {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("\n"+textField.getText());
//                }
//        }));
        button = new JButton("Enter");
        button.setActionCommand("Enter");
        button.addActionListener(buttonAction);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                textAreaOrder.setText("Choose players");
//            }
//        });
//        button.addActionListener((ActionListener)
//                EventHandler.create(ActionListener.class,
//                        this,"startGame",
//                        ""));
        box.add(button);
        textAreaOrder.setEditable(false);

        JPanel p = new JPanel(new BorderLayout());
        p.add(new JScrollPane(textAreaOrder));
        p.add(box, BorderLayout.SOUTH);
        return p;
    }

    public void startGame(ActionEvent e) {
        textAreaOrder.setText("Choose players");
    }

}