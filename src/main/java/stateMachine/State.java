package stateMachine;

import controllers.Hannah;

import javax.swing.*;

public abstract class State {

    public Hannah hannah;

    public State(Hannah hannah) {
        this.hannah = hannah;
    }

    public abstract JTextArea onNextTop();
    public abstract JButton onNextBottom();
    public abstract JTextArea onPreviousTop();
    public abstract JButton onPreviousBottom();

    public abstract String getCurrent();
}

