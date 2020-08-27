package consoles;

import javax.swing.*;

public class ConsolePane extends JPanel implements CommandListener, Terminal {

    private JTextArea textArea;
    private int userInputStart = 0;
    private Command cmd;

    @Override
    public void commandOutput(String text) {
        SwingUtilities.invokeLater(new AppendTask(this, text));
    }

    @Override
    public void commandCompleted(String cmd, int result) {
        appendText("\n> " + cmd + " exited with " + result + "\n");
        appendText("\n");
    }

    @Override
    public void commandFailed(Exception exp) {
        SwingUtilities.invokeLater(new AppendTask(this, "Command failed - " + exp.getMessage()));
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

}
