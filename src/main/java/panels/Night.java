package panels;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Night {

    private ActionListener packageListener;
    private JButton btnContinue;
    private JButton btnDoctor;
    private List<JButton> playerButtonList = new ArrayList<>();
    private String lynchTarget;

    public Night(ActionListener packageListener, List<String> mafiaMember, String lynchTarget) {
        this.packageListener = packageListener;
        this.lynchTarget = lynchTarget;
        btnContinue.addActionListener(packageListener);
        btnDoctor.addActionListener(packageListener);
        for(String name: mafiaMember) {
            displayPlayerButton(name);
        }
    }

    public void displayPlayerButton(String name) {
        JButton btnPlayer = new JButton(name);
        btnPlayer.addActionListener(packageListener);
        playerButtonList.add(btnPlayer);
    }

}
