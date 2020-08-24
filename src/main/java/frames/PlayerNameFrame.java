package frames;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PlayerNameFrame extends JFrame {

    private ActionListener globalListener;
    private JFrame frame;

    public PlayerNameFrame(ActionListener globalListener){
        this.globalListener = globalListener;
        System.out.println("Press PlayerCount to start");
    }

    public List<String> getPlayerNames() {
        List<String> names = new ArrayList<>();
        if(frame.getContentPane().equals("")||frame.getContentPane()==null){
            names.add(frame.getName());
        }else{
            names.add(frame.getContentPane().getName());
        }
        return names;
    }
}
