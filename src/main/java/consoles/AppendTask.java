package consoles;

import javax.swing.*;

public class AppendTask implements Runnable {

    private CommandListener commandListener;
    private CommandListener textAreaOrder;
    private CommandListener textArea;

    public AppendTask() {
        this.commandListener = textAreaOrder;
        this.commandListener = textArea;
    }

    @Override
    public void run() {
        commandListener.commandOutput(textAreaOrder.toString());
        commandListener.commandOutput(textArea.toString());
    }
}
