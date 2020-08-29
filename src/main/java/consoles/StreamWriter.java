package consoles;

import java.io.IOException;
import java.io.OutputStream;

public class StreamWriter extends Thread {

    private OutputStream os;
    private CommandListener listener;

    public StreamWriter(CommandListener listener, OutputStream os) {
        this.listener = listener;
        this.os = os;
        start();
    }

    @Override
    public void run() {
        int value = -1;
        while ((value = os.hashCode()) != -1) {
            listener.commandOutput(Character.toString((char) value));
        }
    }
}
