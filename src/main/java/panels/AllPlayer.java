package panels;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import playerInfo.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AllPlayer {

    private NativeKeyListener packageListener;
    private NativeKeyListener globalListener;
    private List<JButton> playerButtonList = new ArrayList<>();
    private NativeKeyEvent btnContinue;
    private NativeKeyEvent btnHome;
    private NativeKeyEvent display;
    private List<String> playMembers;


    public AllPlayer(NativeKeyListener actionListener, NativeKeyListener globalListener) {
        this.packageListener = actionListener;
        this.globalListener = globalListener;
    }


    private void allPlayerButton(List<String> names) {
        btnHome.getKeyChar();
        btnContinue.getKeyChar();
        for (String name : names) {
//            NativeKeyEvent btnPlayer = new NativeKeyEvent();
//            btnPlayer.getKeyChar();
//            playerButtonList.add(btnPlayer);
        }
    }
    public void setPlayer(Player player) {
        //display = new TextArea(1, 200);
        //display.setText(player.getName()+"\n"+player.getRole());
    }
}
