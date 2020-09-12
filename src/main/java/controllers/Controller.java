package controllers;

import javax.swing.*;

public class Controller extends ConsolePane {

    public JFrame frame;

    public Controller() {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                initFrame();
            }
        });
    }

    public void run() {
    }

}
