package controllers;

import javax.swing.*;

public class Controller {

    public Controller() {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                ConsolePane cp = new ConsolePane();
                cp.initFrame();
            }
        });
    }

    public void run() {
    }

}
