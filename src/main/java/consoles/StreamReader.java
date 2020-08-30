package consoles;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamReader extends Thread implements Runnable {

    private InputStream is;
    private BufferedReader br;
    private JTextField textField;

    public StreamReader(InputStream is) {
        super();
        this.is = is;
        //textField.addActionListener((ActionListener) this);
        InputStreamReader isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
    }
}
