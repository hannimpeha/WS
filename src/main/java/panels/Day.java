package panels;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.ArrayList;
import java.util.List;

public class Day {

    private NativeKeyListener globalListener;
    private NativeKeyListener packageListener;

    private NativeKeyEvent btnContinue;
    private NativeKeyEvent btnHome;
    private NativeKeyEvent btnViewPlayer;
    private List<NativeKeyEvent> playerButtonList = new ArrayList<>();

    public Day(NativeKeyListener packageListener, NativeKeyListener globalListener) {
        this.packageListener = packageListener;
        this.globalListener = globalListener;
        btnContinue.getKeyCode();
        btnContinue.getKeyCode();
        btnViewPlayer.getKeyCode();
    }

}
