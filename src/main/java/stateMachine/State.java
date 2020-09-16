package stateMachine;

import controllers.Hannah;

import javax.swing.*;

public abstract class State {

    public Hannah hannah;

    public State(Hannah hannah) {
        this.hannah = hannah;
    }

    public abstract JPanel onNext();
    public abstract String getCurrent();
}

