package stateMachine;

import javax.swing.*;

public abstract class State {

    public Hannah hannah;

    public State(Hannah hannah) {
        this.hannah = hannah;
    }

    public abstract JPanel onName();
    public abstract JPanel onRole();
    public abstract JPanel onDay();
    public abstract JPanel onNight();

    public abstract String getCurrent();
}

