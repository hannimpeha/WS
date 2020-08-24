package controllers;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.keyboard.NativeKeyEvent;

import util.LoadFileUtil;

public class MainController implements NativeKeyListener {

    private NativeKeyListener packageListener;
    private NativeKeyListener globalListener;
    private LoadFileUtil fu;
    private SetUpController suc;
    private GameController gc;

    public MainController(NativeKeyListener globalListener) {
        this.globalListener = globalListener;
    }

    public void start() {
        new MainController(globalListener);
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
        manufacture(source, suc, fu, gc);
    }

    public static void manufacture(String source, SetUpController suc, LoadFileUtil fu, GameController gc) {
        switch(source) {
            case "Game":
                suc.start();
                fu.newFile(suc.getPlayerNames(), suc.getRoles());
                gc.start(fu.getPlayerInfo());
                break;
            case "Quit":
                break;
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {

    }
}
