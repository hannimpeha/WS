package listener;

import controllers.GameController;
import controllers.MainController;
import controllers.SetUpController;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import util.LoadFileUtil;

public class GlobalKeyListener implements NativeKeyListener {

    private LoadFileUtil fu;
    private SetUpController suc;
    private GameController gc;
    private MainController mc;

    public void procedure(String source) {
        MainController.manufacture(source, suc, fu, gc);
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        String source = NativeKeyEvent.getKeyText(e.getKeyCode());
        procedure(source);
        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException nativeHookException) {
                nativeHookException.printStackTrace();
            }
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
    }
}
