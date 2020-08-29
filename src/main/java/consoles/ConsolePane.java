package consoles;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsolePane extends JPanel implements CommandListener, Terminal {

    private JTextArea textArea;
    private JTextArea textAreaOrder;
    private int userInputStart = 0;
    private Command cmd;

    public ConsolePane(){
        cmd = new Command(this);
        textAreaOrder = new JTextArea(this.getUserOutputStart(), 20, 20);
        textArea = new JTextArea(20, 30);

        ((AbstractDocument) textArea.getDocument()).setDocumentFilter(
                new ProtectedDocumentFilter(this));
        ((AbstractDocument) textAreaOrder.getDocument()).setDocumentFilter(
                new ProtectedDocumentFilter(this));

        add(new JScrollPane(textAreaOrder), new BorderLayout());
        add(new JScrollPane(textArea), new BorderLayout());

        InputMap im = textArea.getInputMap(WHEN_FOCUSED);
        ActionMap am = textArea.getActionMap();

        Action oldAction = am.get("insert-break");
        am.put("insert-break", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int range = textArea.getCaretPosition() - userInputStart;
                try {
                    String text = textArea.getText(userInputStart, range).trim();
                    System.out.println("[" + text + "]");
                    userInputStart += range;
                    if (!cmd.isRunning()) {
                        cmd.execute(text);
                    } else {
                        try {
                            cmd.send(text + "\n");
                        } catch (IOException ex) {
                            appendText("!! Failed to send command to process: " + ex.getMessage() + "\n");
                        }
                    }
                } catch (BadLocationException ex) {
                    Logger.getLogger(ConsolePane.class.getName()).log(Level.SEVERE, null, ex);
                }
                oldAction.actionPerformed(e);
            }
        });

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
                textAreaOrder.getText()));
    }

    @Override
    public String wantStart(String text) {
        return text;
    }

    @Override
    public void appendOrder(String order) {
        textAreaOrder.append(order);
    }

    protected void updateUserOutputPos() {
        textAreaOrder.setCaretPosition(
                textAreaOrder.getText().length()+1);
    }

    @Override
    public void appendText(String text) {
        textArea.append(text);
        updateUserInputPos();
    }

    @Override
    public int getUserInputStart() {
        return 0;
    }

    protected void updateUserInputPos() {
        int pos = textArea.getCaretPosition();
        textArea.setCaretPosition(textArea.getText().length());
        userInputStart = pos;
    }

    @Override
    public String getUserOutputStart() {
        return "Game or Exit";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textAreaOrder = (JTextArea) e.getSource();
    }

}
