package frames;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AboutFrame extends JFrame {

    private ActionListener globalListener;
    private JTextArea myTxtPane;

    public AboutFrame(ActionListener globalListener){
        this.globalListener = globalListener;
        System.out.println("Press Day to start");
        display();
    }

    public void display() {
        myTxtPane.setText("Hannah Lee\nCopyright 2020. All Rights Reserved.");
    }
}
