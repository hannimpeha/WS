package controllers;

import javax.swing.*;

public class Controller extends ConsolePane{

    public Controller() {
        SwingUtilities.invokeLater(new Hannah(){
            @Override
            public void run() {
                initFrame();
            }
        });
    }

    public void run() {
    }

}
