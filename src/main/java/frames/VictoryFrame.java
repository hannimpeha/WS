package frames;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VictoryFrame extends JFrame {

    private ActionListener globalListener;

    public VictoryFrame(ActionListener globalListener){
        this.globalListener = globalListener;
        System.out.println("Press Night to start");
    }

}
