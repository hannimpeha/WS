package state;

public abstract class State {

    public Hannah hannah;

    public State(Hannah hannah) {
        this.hannah = hannah;
    }

    public abstract String onDay();
    public abstract String onNight();
}
