package controllers;

import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.keyboard.NativeKeyEvent;

import logic.Game;
import playerInfo.Player;
import java.util.List;

public class GameController implements NativeKeyListener {

    private NativeKeyListener globalListener;
    private Game g;
    private int position;
    private boolean target;

    public GameController(NativeKeyListener globalListener) {
        this.globalListener = globalListener;
    }


    public void start(List<Player> playerInfo) {
        g = new Game(playerInfo);
        position = -1;
        target = false;
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
    }
}
