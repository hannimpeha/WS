package frames;

import javax.swing.*;
import java.awt.event.ActionListener;

public class DayFrame extends JFrame {

    private ActionListener globalListener;

    public DayFrame(ActionListener globalListener){
        this.globalListener = globalListener;
        System.out.println("Press Day to start");
    }
}
