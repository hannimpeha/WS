package frames;

import playerInfo.Player;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NightFrame extends JFrame {

    private ActionListener globalListener;
    private ActionListener packageListener;
    private List<JButton> playerButtonList = new ArrayList<>();
    private JLabel lblName;
    private JLabel lblRole;
    private JButton btnContinue;

    public NightFrame(ActionListener packageListener, ActionListener globalListener) {
        this.packageListener = packageListener;
        this.globalListener = globalListener;
        System.out.println("Press Night to start");
    }

    public void display() {
        btnContinue = new JButton("Lynch Player");
        btnContinue.addActionListener(packageListener);
    }

    public void displayPlayerButton(String name, int position) {
        JButton btnPlayer = new JButton(name);
        btnPlayer.addActionListener(packageListener);
        playerButtonList.add(btnPlayer);
    }

    public void setDisplay(Player player) {
        lblName.setText(player.getName());
        lblRole.setText(player.getRole());
    }
}