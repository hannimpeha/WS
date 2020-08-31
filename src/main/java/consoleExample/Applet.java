package consoleExample;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.Font;

public class Applet extends JFrame {


    static final long serialVersionUID = 1;

    /** Text area for console output. */
    protected JTextArea textArea;

    /** Text box for user input. */
    protected JTextField textBox;

    /** "GO" button, in case they don't know to hit enter. */
    protected JButton goButton;

    protected PrintStream printStream;
    protected BufferedReader bufferedReader;

    /**
     * This function is called when they hit ENTER or click GO.
     */

    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            goButton.setEnabled(false);
            SwingUtilities.invokeLater(
                    new Thread() {
                        public void run() {
                            String userInput = textBox.getText();
                            printStream.println("> "+userInput);
                            Input.inString = userInput;
                            textBox.setText("");
                            goButton.setEnabled(true);
                        }
                    }
            );
        }
    };

    public void println(final String string) {
        SwingUtilities.invokeLater(
                new Thread() {
                    public void run() {
                        printStream.println(string);
                    }
                }
        );
    }

    public void printmsg(final String string) {
        SwingUtilities.invokeLater(
                new Thread() {
                    public void run() {
                        printStream.print(string);
                    }
                }
        );
    }

    public Applet() throws IOException {
        super("My Applet Title");

        Container contentPane = getContentPane();

        textArea = new JTextArea(30, 60);
        JScrollPane jScrollPane = new JScrollPane(textArea);
        final JScrollBar jScrollBar = jScrollPane.getVerticalScrollBar();
        contentPane.add(BorderLayout.NORTH, jScrollPane);
        textArea.setFocusable(false);
        textArea.setAutoscrolls(true);
        textArea.setFont(new Font("Comic Sans MS", Font.TRUETYPE_FONT, 14));

        // TODO This might be overkill
        new Thread() {
            public void run() {
                while(true) {
                    jScrollBar.setValue(jScrollBar.getMaximum());
                    try{
                        Thread.sleep(100);
                    } catch (Exception e) {}
                }
            }
        }.start();

        JPanel panel;
        contentPane.add(BorderLayout.CENTER, panel = new JPanel());

        panel.add(textBox = new JTextField(55));
        textBox.addActionListener(actionListener);

        panel.add(goButton = new JButton("GO"));
        goButton.addActionListener(actionListener);

        pack();

        // End of GUI stuff

        PipedInputStream inputStream;
        PipedOutputStream outputStream;

        inputStream = new PipedInputStream();
        outputStream = new PipedOutputStream(inputStream);

        bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "ISO8859_1"));
        printStream = new PrintStream(outputStream);

        new Thread() {
            public void run() {
                try {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        textArea.append(line+"\n");
                    }
                } catch (IOException ioException) {
                    textArea.append("ERROR");
                }
            }
        }.start();
    }
}

class Input {

    public static String inString;

    public Input() {
    }
    public static String getString() {
        String inString = "";

        // Wait for input
        while (inString == "") {
            try{
                Thread.sleep(100);
            } catch (Exception e) {}
        }

        return inString;
    }
}