package stateMachine;

public class Hannah {

    private State state;
    private boolean playing = false;

    public Hannah(){
        this.state = new NameState(this);
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

}
