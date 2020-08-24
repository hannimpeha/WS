package frames;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DayFrame extends JFrame {

    private ActionListener globalListener;
    private ActionListener packageListener;
    private JLabel lblDescription1;
    private JLabel lblDescription2;
    private JLabel lblDescription3;
    private JButton btnContinue;
    private JButton btnHome;
    private JButton btnViewPlayers;
    private List<JButton> playerButtonList = new ArrayList<>();

    public DayFrame(ActionListener packageListener, ActionListener globalListener){
        this.globalListener = globalListener;
        this.packageListener = packageListener;
        System.out.println("Press Day to start");
        display();
    }

    public void display() {
        String text = "Talk among yourselves to choose who to lynch.";
        lblDescription1 = new JLabel(text);
        text = "Once once one player has recieved 50% of the votes:";
        lblDescription2 = new JLabel(text);
        text = "select that player and lynch him/her.";
        lblDescription3 = new JLabel(text);

        btnHome = new JButton("Home");
        btnHome.addActionListener(globalListener);
        btnContinue = new JButton("Lynch Player");
        btnContinue.addActionListener(packageListener);
        btnViewPlayers = new JButton("View Players");
        btnViewPlayers.addActionListener(packageListener);
    }
    public void displayPlayerButton(String name, int position){
        JButton btnPlayer = new JButton(name);
        btnPlayer.addActionListener(packageListener);
        playerButtonList.add(btnPlayer);
    }
}

