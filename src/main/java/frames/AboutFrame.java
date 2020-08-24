package frames;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AboutFrame extends JFrame {

    private ActionListener globalListener;

    public AboutFrame(ActionListener globalListener){
        this.globalListener = globalListener;
        System.out.println("Press Day to start");
    }

    public void displayPlayerButton(String name, int y) {
    }
}
