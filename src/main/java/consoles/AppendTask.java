package consoles;

import javax.swing.*;

public class AppendTask implements Runnable {

    private JTextArea textArea;
    private JTextArea textAreaOrder;

        public AppendTask(JTextArea textAreaOrder, JTextArea textArea) {
            textAreaOrder = textArea;
    }

    @Override
    public void run() {
    }
}
