package frames;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PlayerCountFrame extends JFrame {

    private ActionListener globalListener;
    private ActionListener packageListener;
    private JButton btnContinue;
    private JButton btnHome;
    private List<JButton> buttonList = new ArrayList<>();

    public PlayerCountFrame(ActionListener globalListener){
        this.packageListener = packageListener;
        this.globalListener = globalListener;
        System.out.println("Press PlayerCount to start");
        display();
    }

    public void display() {
        btnHome.addActionListener(globalListener);
        btnContinue.addActionListener(packageListener);
    }

    private void displayPlayerButton(int i){
        JButton btnPlayer = new JButton(Integer.toString(i));
        btnPlayer.addActionListener(packageListener);
        buttonList.add(btnPlayer);
    }
}
