package consoles;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConsolePane extends JPanel implements CommandListener, Terminal, Command {

    private JTextArea textArea;
    private JTextArea textAreaOrder;
    private int userInputStart = 0;
    private CommandListener listener;

    public ConsolePane(CommandListener listener) {
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
                    commandOutput(text);
                } catch (BadLocationException badLocationException) {
                    badLocationException.printStackTrace();
                }
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
                commandOutput(text);
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

    @Override
    public void appendOrder(String order) {
        textAreaOrder.append(order);
    }

    @Override
    public void appendText(String text) {
        textArea.append(text);
    }

    @Override
    public int getUserInputStart() {
        return 0;
    }

    @Override
    public String getUserOutputStart() {
        return "Game or Exit";
    }

    @Override
    public void commandOutput(String text) {
        SwingUtilities.invokeLater(new AppendTask());
    }

    @Override
    public void commandCompleted(String text, int result) {
        appendText("\n> " + text + " exited with " + result + "\n");
    }

    @Override
    public void commandFailed(Exception exp) {
        appendText(exp.getMessage());
    }
}
