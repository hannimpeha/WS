package consoleExample;

import consoles.ConsolePane;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamReader extends Thread implements Runnable{

    private BufferedReader br;
    private InputStream is;
    private ActionListener listener;
    private ConsolePane cp;

    public StreamReader(InputStream is) {
        InputStreamReader isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
    }

    public void run() {
        try {
            String line = br.readLine();
            while (line != null) {
                //SwingUtilities.invokeLater(new StreamLine(line));
                //line = br.readLine();
            }
        }
        catch (Exception x) {
            throw new RuntimeException("Stream reading failed.", x);
        }
    }

}


