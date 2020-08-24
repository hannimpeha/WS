package frames;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CheckPlayerFrame extends JFrame{

    private ActionListener packageListener;
    private JButton btnContinue;
    private JButton btnHome;

    public CheckPlayerFrame(ActionListener packageListener){
        this.packageListener = packageListener;
        System.out.println("Press CheckPlayer to start");
        display();
    }

    public void display() {
        btnContinue.addActionListener(packageListener);
    }

    public void displayPlayerButton(String name, int y) {
    }
}

