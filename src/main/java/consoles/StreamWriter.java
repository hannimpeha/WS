package consoles;

import java.io.OutputStream;

public class StreamWriter extends Thread {

    private OutputStream os;
    private CommandListener listener;

    public StreamWriter(CommandListener listener, OutputStream os) {
        this.listener = listener;
        this.os = os;
        start();
    }
}
