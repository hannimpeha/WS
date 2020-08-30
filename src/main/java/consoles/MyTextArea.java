package consoles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyTextArea extends JTextArea implements KeyListener, ActionListener {

    private int ENTER = 10;
    private int initialCaretPosition = 0;
    private int currentCaretPosition = 0;
    private boolean inputAvailable = false;
    private JTextArea textArea;
    private JTextArea textAreaOrder;
    private int userInputStart = 0;
    protected ActionListener packageListener;

    public MyTextArea(String text) {
        this.packageListener = packageListener;
        setText(text);
        setRows(20);
        setColumns(20);
        configureJTextAreaForInputOutput(displayOrder());
        configureJTextAreaForInputOutput(displayListener());
    }

    public JTextArea displayOrder() {
        textAreaOrder = new MyTextArea("Game or Exit");
        textAreaOrder.setEditable(true);
        return textAreaOrder;
    }

    public JTextArea displayListener() {
        textArea = new MyTextArea("");
        textArea.setEditable(true);
        return textArea;
    }

    public void configureJTextAreaForInputOutput(JTextArea jta) {
        jta.addKeyListener(this);
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

    public String outputOfJTextArea() {
        return textAreaOrder.getText();
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