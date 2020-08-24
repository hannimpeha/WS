package frames;

import javax.swing.*;
import java.awt.event.ActionListener;

public class NightFrame extends JFrame {

    private ActionListener globalListener;

    public NightFrame(ActionListener globalListener){
        this.globalListener = globalListener;
        System.out.println("Press Night to start");
    }
}
