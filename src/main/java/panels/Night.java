package panels;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.ArrayList;
import java.util.List;

public class Night {

    private NativeKeyListener packageListener;
    private NativeKeyEvent btnContinue;
    private NativeKeyEvent btnDoctor;
    private List<NativeKeyEvent> playerButtonList = new ArrayList<>();
    private String lynchTarget;

    public Night(NativeKeyListener packageListener, List<String> mafiaMember, String lynchTarget) {
        this.packageListener = packageListener;
        this.lynchTarget = lynchTarget;
        btnContinue.getKeyCode();
        btnDoctor.getKeyCode();
        for(String name: mafiaMember) {
            displayPlayerButton(name);
        }
    }

    public void displayPlayerButton(String name) {
//        JButton btnPlayer = new JButton(name);
//        btnPlayer.addActionListener(packageListener);
//        playerButtonList.add(btnPlayer);
    }

}
