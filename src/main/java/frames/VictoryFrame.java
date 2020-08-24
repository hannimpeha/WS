package frames;

import playerInfo.Player;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VictoryFrame extends JFrame {

    private ActionListener globalListener;
    private JLabel winner_role;
    private JLabel winner_name;
    private JButton btnContinue;
    private JButton btnHome;
    private JLabel status;

    public VictoryFrame(ActionListener globalListener){
        this.globalListener = globalListener;
        System.out.println("Press Night to start");
        display();
    }

    public void display() {
        btnHome.addActionListener(globalListener);
        winner_name = new JLabel("", 60);
        winner_role = new JLabel("", 60);
    }

    public void setPlayerInfo(Player p) {
        if(p.getStatus()!=0)  {
            status = new JLabel(String.valueOf(p.getStatus()));
        }

    }

    public void setWinner(String victor) {
        winner_name.setText(victor);
    }
}
