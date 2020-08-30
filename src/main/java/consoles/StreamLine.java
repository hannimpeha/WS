package consoles;

import javax.swing.*;

public class StreamLine implements Runnable {

    private final String text;
    private JTextArea textAreaOrder;
    private JTextArea textArea;

    public StreamLine(String txt) {
        text = txt + "\n";
    }

    public void run() {
        StreamLine.this.textAreaOrder.append(text);
    }
}
