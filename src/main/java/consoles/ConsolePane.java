package consoles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.EventHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class ConsolePane extends JPanel implements KeyListener, ActionListener{

    private int ENTER = 10;
    private int initialCaretPosition = 0;
    private int currentCaretPosition = 0;
    private boolean inputAvailable = false;
    private final JTextField textField = new JTextField(20);
    private final JTextArea textAreaOrder = new JTextArea(20, 30);
    private int userInputStart = 0;
    private ActionListener listener;

    public ConsolePane(ActionListener listener) {
        this.listener = listener;
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
        JButton button = new JButton();
        button.addActionListener((ActionListener)
                EventHandler.create(ActionListener.class
                                ,this,"startGame",
                                ""));
        box.add(button);
        textAreaOrder.setEditable(false);
        textAreaOrder.addKeyListener(this);

        JPanel p = new JPanel(new BorderLayout());
        p.add(new JScrollPane(textAreaOrder));
        p.add(box, BorderLayout.SOUTH);
        return p;
    }

    public void startGame(ActionEvent e) {
        textAreaOrder.setText("Type Players' names");
    }

    public String getInputFromJTextField() {
        int len = 0;
        String inputFromUser = "";
        while (true) {
            synchronized (this) {
                if (inputAvailable == true) {
                    len = currentCaretPosition - initialCaretPosition;

                    try {
                        inputFromUser = textField.getText(initialCaretPosition, len);
                        initialCaretPosition = currentCaretPosition;
                    } catch (Exception e) {
                        inputFromUser = "";
                        return inputFromUser;
                    }
                    inputAvailable = false;
                    return inputFromUser;
                } else {
                    try {
                        wait();
                        continue;
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    public void outputToJTextField(String text) {
        textField.getActionListeners();
        textField.setCaretPosition(textField.getDocument().getLength());
        synchronized (this) {
            initialCaretPosition = textField.getCaretPosition();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int cCurrPos = textField.getCaretPosition();
        textField.selectAll();
        textField.copy();
        textField.select(cCurrPos, cCurrPos);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        synchronized (this) {
            if(e.getKeyCode()==ENTER) {
                textField.setCaretPosition(textField.getDocument().getLength());
                synchronized (this) {
                    currentCaretPosition = textField.getCaretPosition();
                    try {
                        String charAtInitialCaretPosition = textField.getText(initialCaretPosition, 1);
                        if ((charAtInitialCaretPosition.equals("\n")) == true) {
                            initialCaretPosition++;
                        }
                    } catch (Exception exception) {
                    }
                    if ((currentCaretPosition - initialCaretPosition) > 0) {
                        inputAvailable = true;
                        notifyAll();
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}