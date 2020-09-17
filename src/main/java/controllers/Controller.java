package controllers;

import javax.swing.*;

public class Controller {

    public Controller() {
        SwingUtilities.invokeLater(new Hannah(){
            @Override
            public void run() {
                ConsolePane cp = new ConsolePane(this);
                cp.initFrame();
            }
        });
    }

    public void run() {
    }

}
