package controllers;

import stateMachine.Hannah;

import javax.swing.*;

public class Controller {

    public Controller() {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {

            }
        });
    }

    public void run() {
        Hannah hannah = new Hannah();
        new ConsolePane(hannah).initFrame();
    }

}
