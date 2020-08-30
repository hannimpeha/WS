package consoles;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StreamWriter extends OutputStream {

    private ByteArrayOutputStream buf = new ByteArrayOutputStream();
    private JTextArea textArea;

    public StreamWriter(JTextArea textArea) {
        super();
        this.textArea = textArea;
    }

    @Override
    public void flush() throws IOException {
        textArea.append(buf.toString("UTF-8"));
        buf.reset();
    }

    @Override
    public void write(int b) throws IOException {
        buf.write(b);
    }
}
