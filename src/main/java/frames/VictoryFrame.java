package frames;

import playerInfo.Player;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VictoryFrame extends JFrame {

    private ActionListener globalListener;

    public VictoryFrame(ActionListener globalListener){
        this.globalListener = globalListener;
        System.out.println("Press Night to start");
    }

    public void setPlayerInfo(Player copy) {
    }

    public void setWinner(String victor) {
    }
}
