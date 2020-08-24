package listener;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class MainPanel {

    private NativeKeyListener globalListener;
    private NativeKeyListener packageListener;
    private NativeKeyEvent btnContinue;
    private NativeKeyEvent btnHome;

    public MainPanel(NativeKeyListener packageListener, NativeKeyListener globalListener) {
        this.packageListener = packageListener;
        this.globalListener = globalListener;
        btnContinue.getKeyCode();
        btnHome.getKeyCode();
    }

}
