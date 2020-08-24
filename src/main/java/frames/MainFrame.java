package frames;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private ActionListener globalListener;

    public MainFrame(ActionListener globalListener){
        this.globalListener = globalListener;
        System.out.println("Press Day to start");
    }

    public void displayPlayerButton(String name, int y) {
    }
}
