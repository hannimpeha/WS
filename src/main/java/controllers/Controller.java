package controllers;

import graphViz.MyRunnable;
import javax.swing.*;

public class Controller extends ConsolePane {

    public JFrame frame;
    public MyRunnable r;
    public ActionListener listener;

    public Controller() {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                initFrame();
                r = new MyRunnable(listener);
                new Thread(r).start();
            }
        });
    }

    public void run() {
    }

}
