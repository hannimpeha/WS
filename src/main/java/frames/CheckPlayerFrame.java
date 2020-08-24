package frames;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CheckPlayerFrame extends JFrame{

    private ActionListener globalListener;

    public CheckPlayerFrame(ActionListener globalListener){
        this.globalListener = globalListener;
        System.out.println("Press CheckPlayer to start");
    }
}

