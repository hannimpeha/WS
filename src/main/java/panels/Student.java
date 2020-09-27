package panels;

import javax.swing.*;

public class Student {

    private State state;

    public Student() {
        this.state = new PlayerNames();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public String getName() { return state.getName(); }

    public JPanel createPanel(){ return state.createPanel();}

    public JPanel createButton() {return state.createButton();}

}
