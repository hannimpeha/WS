package stateMachine;

import javax.swing.*;

public abstract class State {

    public Hannah hannah;

    public State(Hannah hannah) {
        this.hannah = hannah;
    }

    public abstract JTextArea onName();
    public abstract JTextArea onRole();
    public abstract JTextArea onDay();
    public abstract JTextArea onNight();

    public abstract String getCurrent();
}

