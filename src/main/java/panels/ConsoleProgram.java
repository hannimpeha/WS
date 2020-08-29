package panels;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConsoleProgram extends Components implements KeyListener {

    public JTextArea textArea;
    public JFrame frame;
    public JScrollPane scrollPane;

    public void ConsoleProgram() {
        textArea = setupJTextAreaAndGet("");
        textArea.addKeyListener(this);
        frame = setupJFrameAndGet();
        scrollPane = setupScrollableJTextAreaAndGet(textArea);
        frame.add(scrollPane);
    }

    public void begin() {
        outputToJTextArea(
                "Enter some input (press enter after inputting): ");
        String input = getInputFromJTextArea();
        outputToJTextArea("User input was: " + input + "\n\n");
    }

//    public void configureJTextAreaForInputOutput() {
//        textArea.addKeyListener(this);
//    }


    @Override
    public void keyTyped(KeyEvent e) {
        synchronized (this) {
            if (textArea.getCaretPosition() <= 0) {
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
