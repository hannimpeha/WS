package controllers;

import listener.GlobalKeyListener;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import util.LoadFileUtil;

public class Controller implements NativeKeyListener {

    private NativeKeyEvent frame;
    private LoadFileUtil fu;
    private SetUpController suc;
    private GameController gc;
    private MainController mc;

    public void run() throws NativeHookException {
        suc = new SetUpController(frame, this);
        gc = new GameController(frame, this);
        mc = new MainController(frame, this);
        fu = new LoadFileUtil();
        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(new GlobalKeyListener());
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
