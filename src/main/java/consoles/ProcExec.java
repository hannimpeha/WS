package consoles;

import consoleExample.StreamReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProcExec implements ActionListener, Runnable {

    private static final String GAME = "Game";
    private static final String EXIT = "Exit";
    private static final String RUN = "Run";

    private JTextArea textAreaOrder;
    private JTextField textField;
    private ConsolePane cp;
    private ProcessBuilder procBuilder;


    public ProcExec(ActionListener listener) {
        procBuilder = new ProcessBuilder();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = textField.getText();
                if(GAME.equals(actionCommand)) {
                    textAreaOrder.setText("Type Players's name");
                    try {
                        execute();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                } else if (EXIT.equals(actionCommand)) {
                    System.exit(0);
                }
            }
        });
    }

    private int execute() throws IOException, InterruptedException {
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
        int status = proc.waitFor();
        stderrThread.join();
        stdoutThread.join();
        return status;
    }

    @Override
    public void run() {
        createFrame();
    }

    public void createFrame() {
        JFrame frame = new JFrame("Hannah's Mafia Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new ConsolePane(this).display());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
