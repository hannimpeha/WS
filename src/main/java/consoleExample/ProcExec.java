package consoleExample;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class ProcExec implements ActionListener, Runnable {
    private static final String CLEAR = "Clear";
    private static final String EXIT = "Exit";
    private static final String RUN = "Run";

    private JTextArea commandOutput;
    private JTextArea textArea;
    private ProcessBuilder procBuilder;

    public ProcExec() {
        procBuilder = new ProcessBuilder();
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String actionCommand = actionEvent.getActionCommand();
        if (CLEAR.equals(actionCommand)) {
            textArea.setText("");
        }
        else if (EXIT.equals(actionCommand)) {
            System.exit(0);
        }
        else if (RUN.equals(actionCommand)) {
            try {
                execute();
            }
            catch (Exception x) {
                x.printStackTrace();
            }
        }
    }

    public void run() {
        createAndDisplayGui();
    }

    private void createAndDisplayGui() {
        JFrame frame = new JFrame("Process Executor");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(createTopPanel(), BorderLayout.PAGE_START);
        frame.add(createCommandPanel(), BorderLayout.CENTER);
        frame.add(createButtonsPanel(), BorderLayout.PAGE_END);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JButton createButton(String text, int mnemonic, String tooltip) {
        JButton button = new JButton(text);
        button.setMnemonic(mnemonic);
        button.setToolTipText(tooltip);
        button.addActionListener(this);
        return button;
    }

    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(createButton(RUN, KeyEvent.VK_R, "Run entered command."));
        buttonsPanel.add(createButton(CLEAR, KeyEvent.VK_C, "Removes entered command."));
        buttonsPanel.add(createButton(EXIT, KeyEvent.VK_X, "Exit application."));
        return buttonsPanel;
    }

    private JSplitPane createCommandPanel() {
        textArea = new JTextArea(30, 40);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane cmdScrollPane = new JScrollPane(textArea);
        commandOutput = new JTextArea(30, 80);
        JScrollPane outputScrollPane = new JScrollPane(commandOutput);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                cmdScrollPane,
                outputScrollPane);
        return splitPane;
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JLabel label = new JLabel("Enter a command...");
        topPanel.add(label);
        return topPanel;
    }

    private int execute() throws IOException, InterruptedException {
        commandOutput.setText("");
        String raw = textArea.getText();
        String[] words = raw.split(" ");
        String[] command = new String[words.length + 2];
        command[0] = "cmd.exe";
        command[1] = "/C";
        System.arraycopy(words, 0, command, 2, words.length);
        procBuilder.command(command);
        Process proc = procBuilder.start();
        ProcHandler stdout = new ProcHandler(proc.getInputStream());
        ProcHandler stderr = new ProcHandler(proc.getErrorStream());
        Thread stdoutThread = new Thread(stdout);
        stdoutThread.start();
        Thread stderrThread = new Thread(stderr);
        stderrThread.start();
        int status = proc.waitFor();
        stderrThread.join();
        stdoutThread.join();
        return status;
    }

    private class ProcHandler implements Runnable {
        private BufferedReader streamReader;

        public ProcHandler(InputStream is) {
            InputStreamReader isr = new InputStreamReader(is);
            streamReader = new BufferedReader(isr);
        }

        public void run() {
            try {
                String line = streamReader.readLine();
                while (line != null) {
                    SwingUtilities.invokeLater(new StreamLine(line));
                    line = streamReader.readLine();
                }
            }
            catch (Exception x) {
                throw new RuntimeException("Stream reading failed.", x);
            }
        }
    }

    private class StreamLine implements Runnable {
        private final String text;

        public StreamLine(String txt) {
            text = txt + "\n";
        }

        public void run() {
            ProcExec.this.commandOutput.append(text);
        }
    }

    public static void main(String[] args) {
        ProcExec instance = new ProcExec();
        EventQueue.invokeLater(instance);
    }
}