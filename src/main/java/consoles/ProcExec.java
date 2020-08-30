package consoles;

import consoleExample.StreamReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProcExec implements Runnable {

    private JTextArea textAreaOrder;
    private JTextField textField;
    private JButton button;
    private ProcessBuilder procBuilder;
    private ActionListener listener;

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
        createFrame();
    }

    public void createFrame() {
        JFrame frame = new JFrame("Hannah's Mafia Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new ConsolePane().display(button));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
