package controllers;

import stateMachine.NameState;
import stateMachine.State;

public class Hannah implements Runnable{

    private State state;
    private boolean playing = false;

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
        this.state = new NameState(this);
        setPlaying(true);
    }
}
