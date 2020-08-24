package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AllPlayer {

    private ActionListener packageListener;
    private ActionListener globalListener;
    private List<String> playMembers;
    private JButton btnContinue;
    private JButton btnHome;
    private List<JButton> playerButtonList = new ArrayList<>();
    private TextArea display;

    public AllPlayer(ActionListener actionListener, ActionListener globalListener) {
        this.packageListener = actionListener;
        this.globalListener = globalListener;
    }


    private void allPlayerButton(List<String> names) {
        btnHome.addActionListener(globalListener);
        btnContinue.addActionListener(packageListener);
        for (String name : names) {
            JButton btnPlayer = new JButton(name);
            btnPlayer.addActionListener(packageListener);
            playerButtonList.add(btnPlayer);
        }
    }
    public void setPlayer(playerInfo.Player player) {
        display = new TextArea(1, 200);
        display.setText(player.getName()+"\n"+player.getRole());
    }
}
