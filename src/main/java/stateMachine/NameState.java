package stateMachine;

import controllers.Hannah;
import panels.PlayerNames;

import javax.swing.*;

public class NameState extends State {

    public NameState(Hannah hannah) {
        super(hannah);
    }

    @Override
    public JPanel onContinue() {
        JPanel action = hannah.getState().onPrevious();
        hannah.changeState(new RoleState(hannah));
        return action;
    }

    @Override
    public JPanel onPrevious() {
        hannah.changeState(new RoleState(hannah));
        return new PlayerNames();
    }


    @Override
    public String getCurrent() {
        return "Name";
    }
}
