package frames;

import playerInfo.Player;

import javax.swing.*;
import java.awt.event.ActionListener;

public class NightFrame extends JFrame {

    private ActionListener globalListener;

    public NightFrame(ActionListener globalListener){
        this.globalListener = globalListener;
        System.out.println("Press Night to start");
    }

    public void setDisplay(Player player) {
    }

    public void displayPlayerButton(String name, int y) {
    }
}
