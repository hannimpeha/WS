package consoles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConsolePane extends JPanel implements KeyListener, ActionListener, Runnable{

    private int ENTER = 10;
    private int initialCaretPosition = 0;
    private int currentCaretPosition = 0;
    private boolean inputAvailable = false;
    private JTextArea textArea;
    private JTextArea textAreaOrder;
    private int userInputStart = 0;
    private ActionListener listener;
    private Runnable runner;

    public ConsolePane(ActionListener listener) {
        this.listener = listener;
        configureJTextAreaForInputOutput(displayOrder());
        configureJTextAreaForInputOutput(displayListener());
    }

    public void begin() {
        while (true) {
            String input = getInputFromJTextArea();
            outputToJTextArea("User input was: " + input + "\n\n");
        }
    }

    public JTextArea displayOrder() {
        textAreaOrder = new JTextArea(20, 20);
        add(new JScrollPane(textAreaOrder), new BorderLayout());
        return textAreaOrder;
    }

    private JTextArea displayListener() {
        textArea = new JTextArea(20, 30);
        add(new JScrollPane(textArea), new BorderLayout());
        return textArea;
    }

    public void configureJTextAreaForInputOutput(JTextArea jta) {
        jta.addKeyListener(this);
        for (MouseListener listener : jta.getMouseListeners()) {
            jta.removeMouseListener(listener);
        }
        for (MouseMotionListener listener : jta.getMouseMotionListeners()) {
            jta.removeMouseMotionListener(listener);
        }
        for (MouseWheelListener listener : jta.getMouseWheelListeners()) {
            jta.removeMouseWheelListener(listener);
        }
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
    public void run() {
        SwingUtilities.invokeLater(runner);
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