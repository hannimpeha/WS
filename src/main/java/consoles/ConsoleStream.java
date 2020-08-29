package consoles;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;

public class ConsoleStream extends Thread implements Runnable {

    private static final int WHEN_FOCUSED = 1;
    private JTextArea textArea;
    private JTextArea textAreaOrder;
    private int userInputStart = 0;

    public ConsoleStream() {
        displayOrder();
        displayListener();
    }

    public JTextArea displayOrder() {
        textAreaOrder = new JTextArea(getUserOutputStart(),
                20, 20);
        ((AbstractDocument) textAreaOrder.getDocument()).
                setDocumentFilter(
                        new UnprotectedDocumentFilter(getUserOutputStart()));

        InputMap im = textAreaOrder.getInputMap(WHEN_FOCUSED);
        ActionMap am = textAreaOrder.getActionMap();
        Action newAction = am.get("start");
        am.put("start", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int range = textArea.getCaretPosition() - userInputStart;
                String text = null;
                try {
                    text = textArea.getText(userInputStart, range).trim();
                    userInputStart += range;
                    appendOrder(text);
                } catch (BadLocationException badLocationException) {
                    badLocationException.printStackTrace();
                }
            }
            void newAction() {
                newAction();
            }
        });
        return textAreaOrder;
    }

    private JTextArea displayListener() {
        textArea = new JTextArea(20, 30);
        new JScrollPane(textArea);
        ((AbstractDocument) textArea.getDocument()).setDocumentFilter(
                new ProtectedDocumentFilter(textArea.getText()));
        InputMap im = textAreaOrder.getInputMap(WHEN_FOCUSED);
        ActionMap am = textAreaOrder.getActionMap();
        Action oldAction = am.get("start");
        am.put("start", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textAreaOrder.getText();
                appendText(text);
            }

            void oldAction() {
                oldAction();
            }
        });
        return textArea;
    }

    protected void updateUserOutputPos() {
        textAreaOrder.setCaretPosition(
                textAreaOrder.getText().length() + 1);
    }

    protected void updateUserInputPos() {
        int pos = textArea.getCaretPosition();
        textArea.setCaretPosition(textArea.getText().length());
        userInputStart = pos;
    }

    public void appendOrder(String order) {
        textAreaOrder.append(order);
    }

    public void appendText(String text) {
        textArea.append(text);
    }

    public int getUserInputStart() {
        return 0;
    }

    public String getUserInput() {
        return textArea.getText();
    }

    public String getUserOutputStart() {
        return "Game or Exit";
    }

    public String getUserOuput() {
        return textAreaOrder.getText();
    }
}
