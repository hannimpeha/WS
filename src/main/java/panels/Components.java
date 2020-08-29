package panels;

import javax.swing.*;
import java.awt.*;

public class Components {

    public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private boolean inputAvailable = false;
    private int initialCaretPosition = 0;
    private int currentCaretPosition = 0;
    public JTextArea textArea;

    public Components() {
        textArea = setupJTextAreaAndGet("");
    }

    public JFrame setupJFrameAndGet() {
        JFrame tmpJF = new JFrame("Hannah's Mafia Game");
        tmpJF.setSize(screenSize.width-100, screenSize.height-150);
        tmpJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tmpJF.setLayout(null);
        tmpJF.setLocationRelativeTo(null);
        tmpJF.setVisible(true);
        tmpJF.pack();
        return tmpJF;
    }

    public JTextArea setupJTextAreaAndGet(String text) {
        JTextArea tmpJTA = new JTextArea(text, 1000, 100);
        tmpJTA.setEditable(true);
        tmpJTA.setLineWrap(true);
        tmpJTA.setWrapStyleWord(true);
        tmpJTA.setVisible(true);
        return tmpJTA;
    }

    public JScrollPane setupScrollableJTextAreaAndGet(JTextArea textArea) {
        JScrollPane tmpJSP = new JScrollPane(textArea);
        tmpJSP.setBounds(10, 10, screenSize.width-180, screenSize.height-180);
        tmpJSP.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tmpJSP.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        return tmpJSP;
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
        textArea.append(text);
        textArea.setCaretPosition(textArea.getDocument().getLength());
        synchronized (this) {
            initialCaretPosition = textArea.getCaretPosition();
        }
    }
}
