package controllers;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Controller extends ConsolePane{

    public Controller(Hannah hannah) {
        super(hannah);
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
