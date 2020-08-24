package panels;

import org.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Day {

    private NativeKeyListener globalListener;
    private NativeKeyListener packageListener;

    private JButton btnContinue;
    private JButton btnHome;
    private JButton btnViewPlayer;
    private List<JButton> playerButtonList = new ArrayList<>();

    public Day(NativeKeyListener packageListener, NativeKeyListener globalListener) {
        this.packageListener = packageListener;
        this.globalListener = globalListener;
        btnHome.addActionListener(packageListener);
        btnContinue.addActionListener(packageListener);
        btnViewPlayer.addActionListener(packageListener);
    }

}
