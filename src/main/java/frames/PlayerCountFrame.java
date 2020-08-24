package frames;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PlayerCountFrame extends JFrame {

    private ActionListener globalListener;

    public PlayerCountFrame(ActionListener globalListener){
        this.globalListener = globalListener;
        System.out.println("Press PlayerCount to start");
    }
}
