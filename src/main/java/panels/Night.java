package panels;

import org.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;s
import java.util.ArrayList;
import java.util.List;

public class Night {

    private NativeKeyListener packageListener;
    private JButton btnContinue;
    private JButton btnDoctor;
    private List<JButton> playerButtonList = new ArrayList<>();
    private String lynchTarget;

    public Night(NativeKeyListener packageListener, List<String> mafiaMember, String lynchTarget) {
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
