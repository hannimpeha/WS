package consoles;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsolePane extends JPanel implements ActionListener, Runnable{

    private JTextArea textArea;
    private JTextArea textAreaOrder;
    private int userInputStart = 0;
    private ActionListener listener;
    private Runnable runner;

    public ConsolePane(ActionListener listener) {
        this.listener = listener;
        displayOrder();
        displayListener();
    }

    public void displayOrder() {
        textAreaOrder = new JTextArea(getUserOutputStart(),
                20, 20);
        add(new JScrollPane(textAreaOrder), new BorderLayout());
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
                    textArea.append(text);
                } catch (BadLocationException badLocationException) {
                    badLocationException.printStackTrace();
                }
            }
            void newAction() {
                newAction();
            }
        });
    }

    private void displayListener() {
        textArea = new JTextArea(20, 30);
        add(new JScrollPane(textArea), new BorderLayout());
        ((AbstractDocument) textArea.getDocument()).setDocumentFilter(
                new ProtectedDocumentFilter(textArea.getText()));
        InputMap im = textAreaOrder.getInputMap(WHEN_FOCUSED);
        ActionMap am = textAreaOrder.getActionMap();
        Action oldAction = am.get("start");
        am.put("start", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textAreaOrder.getText();
                textAreaOrder.append(text);
            }
            void oldAction() {
                oldAction();
            }
        });

    }

    protected void updateUserOutputPos() {
        textAreaOrder.setCaretPosition(
                textAreaOrder.getText().length()+1);
    }

    protected void updateUserInputPos() {
        int pos = textArea.getCaretPosition();
        textArea.setCaretPosition(textArea.getText().length());
        userInputStart = pos;
    }

    public int getUserInputStart() {
        return 0;
    }

    public String getUserInput() {return textArea.getText();}

    public String getUserOutputStart() {
        return "New Game // Continue Game // Test";
    }

    public String getUserOuput() { return textAreaOrder.getText();}

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void run() {
        SwingUtilities.invokeLater(runner);
    }

}