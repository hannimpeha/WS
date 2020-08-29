package consoles;

import controllers.Controller;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;

public class ConsolePane extends JPanel implements CommandListener, Terminal {

    private Command cmd;
    private JTextArea textArea;
    private JTextArea textAreaOrder;
    private int userInputStart = 0;


    public ConsolePane() {
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
    }

    private void displayListener() {
        textArea = new JTextArea(20, 30);
        add(new JScrollPane(textArea), new BorderLayout());
        ((AbstractDocument) textArea.getDocument()).setDocumentFilter(
                new ProtectedDocumentFilter(textArea.getText()));
        InputMap im = textArea.getInputMap(WHEN_FOCUSED);
        ActionMap am = textArea.getActionMap();
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
    public void commandOutput(String text) {
        SwingUtilities.invokeLater(new AppendTask(
                this, text, textAreaOrder.getText()));
    }

    @Override
    public void commandCompleted(String cmd, int result) {
        appendText("\n> " + cmd + " exited with " + result + "\n");
        appendText("\n");
    }

    @Override
    public void commandFailed(Exception exp) {
        SwingUtilities.invokeLater(new AppendTask(
                this, "Command failed - " + exp.getMessage(),
                textArea.getText()));
    }

    @Override
    public int getUserInputStart() {
        return 0;
    }

    @Override
    public String getUserOutputStart() {
        return "Game or Exit";
    }

}
