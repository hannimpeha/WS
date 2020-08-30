package consoles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConsolePane extends JPanel implements KeyListener, ActionListener{

    private int ENTER = 10;
    private int initialCaretPosition = 0;
    private int currentCaretPosition = 0;
    private boolean inputAvailable = false;
    private JTextArea textArea;
    private JTextArea textAreaOrder;
    private int userInputStart = 0;
    private ActionListener listener;

    public ConsolePane(ActionListener listener) {
        this.listener = listener;
        configureJTextAreaForInputOutput(displayOrder());
        configureJTextAreaForInputOutput(displayListener());
    }

    public JTextArea displayOrder() {
        textAreaOrder = new JTextArea(20, 20);
        outputToJTextArea("Game or Exit");
        textAreaOrder.setEditable(true);
        return textAreaOrder;
    }

    public JTextArea displayListener() {
        textArea = new JTextArea(20, 30);
        textArea.setEditable(true);
        return textArea;
    }

    public void configureJTextAreaForInputOutput(JTextArea jta) {
        jta.addKeyListener(this);
        add(new JScrollPane(jta), new BorderLayout());
    }

    public String getInputFromJTextArea() {
        int len = 0;
        String inputFromUser = "";
        while (true) {
            synchronized (this) {
                if (inputAvailable == true) {
                    len = currentCaretPosition - initialCaretPosition;

                    try {
                        inputFromUser = textArea.getText(initialCaretPosition, len);
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

    public void outputToJTextArea(String text) {
        textAreaOrder.append(text);
        textAreaOrder.setCaretPosition(textAreaOrder.getDocument().getLength());
        synchronized (this) {
            initialCaretPosition = textAreaOrder.getCaretPosition();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int cCurrPos = textArea.getCaretPosition();
        textArea.selectAll();
        textArea.copy();
        textArea.select(cCurrPos, cCurrPos);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        synchronized (this) {
            if(e.getKeyCode()==ENTER) {
                textArea.setCaretPosition(textArea.getDocument().getLength());
                synchronized (this) {
                    currentCaretPosition = textArea.getCaretPosition();
                    try {
                        String charAtInitialCaretPosition = textArea.getText(initialCaretPosition, 1);
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