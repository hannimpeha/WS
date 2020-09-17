package controllers;

import panels.PlayerNames;

public class Hannah implements Runnable{

    private static State state;
    private boolean playing = false;

    public Hannah() {
        this.state = new PlayerNames();
        setPlaying(true);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isPlaying() {
        return playing;
    }

    @Override
    public void run() {

    }
}
