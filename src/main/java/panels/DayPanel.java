package panels;

import consoleExample.ConsoleExample;
import consoles.Command;
import consoles.ConsolePane;
import consoles.ProtectedDocumentFilter;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DayPanel extends ConsolePane {

    protected int userInputStart = 0;
    protected JTextArea textArea = new JTextArea(30, 30);
    protected ConsolePane cp;
    protected Command cmd = new Command(cp);

    public DayPanel() {

        setLayout(new BorderLayout());
        ((AbstractDocument) textArea.getDocument()).setDocumentFilter(
                new ProtectedDocumentFilter(this));
        add(new JScrollPane(textArea));

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
                    Logger.getLogger(ConsoleExample.class.getName()).log(Level.SEVERE, null, ex);
                }
                oldAction.actionPerformed(e);
            }
        });
        setTheme();
    }

    public void start() {
        System.out.println("Press Day to Continue.");
    }

    protected void setTheme(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Nimbus theme is not found.");
            e.printStackTrace();
        }
    }

}
