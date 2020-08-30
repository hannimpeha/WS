package consoles;

import consoleExample.ConsoleExample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;

public class StreamReader extends Thread implements ActionListener{

    private InputStream is;
    private ActionListener listener;
    private ConsolePane cp;

    public StreamReader(ActionListener listener, InputStream is) {
        this.is = is;
        this.listener = listener;
        run();
    }

    public void run() {
        try {
            int value = -1;
            while ((value = is.read()) != -1) {
                //listener(actionPerformed());
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
