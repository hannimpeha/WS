package controllers;

import javax.swing.*;

public class Controller {

    private ConsolePane cp;

    public Controller() {
        SwingUtilities.invokeLater(new Hannah(){
            @Override
            public void run() {
                cp = new ConsolePane(this);
                cp.initFrame();
            }
        });
    }

    public void run() {
    }

}
