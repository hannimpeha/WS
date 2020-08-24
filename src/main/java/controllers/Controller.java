package controllers;

import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import util.LoadFileUtil;

public class Controller implements NativeKeyListener {

    private LoadFileUtil fu;
    private SetUpController suc;
    private GameController gc;
    private MainController mc;

    public void run() {
        suc = new SetUpController(this);
        gc = new GameController(this);
        mc = new MainController(this);
        fu = new LoadFileUtil();
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

    public void procedure(String source) {
        MainController.manufacture(source, suc, fu, gc);
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
    }

}
