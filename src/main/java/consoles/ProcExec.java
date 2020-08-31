package consoles;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.IOException;

public class ProcExec implements Runnable {

    public JTextArea textAreaOrder;
    public JTextField textField;
    public JButton button;
    public ProcessBuilder procBuilder;
    public ActionListener listener;
    public KeyListener keyListener;
    public ActionListener textAction;

    public ProcExec(ActionListener listener) {
        this.listener = listener;
        procBuilder = new ProcessBuilder();
    }

    public void execute() throws IOException, InterruptedException {
        textAreaOrder.setText("");
        String raw = textField.getText();
        String[] words = raw.split(" ");
        String[] command = new String[words.length];
        System.arraycopy(words, 0, command, 2, words.length);
        procBuilder.command(command);
        Process proc = procBuilder.start();
        StreamReader stdout = new StreamReader(proc.getInputStream());
        StreamReader stderr = new StreamReader(proc.getErrorStream());
        Thread stdoutThread = new Thread(stdout);
        stdoutThread.start();
        Thread stderrThread = new Thread(stderr);
        stderrThread.start();
        stderrThread.join();
        stdoutThread.join();
        System.out.println(stderrThread.toString());
    }

    @Override
    public void run() {
    }

}
