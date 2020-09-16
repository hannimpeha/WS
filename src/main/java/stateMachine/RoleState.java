package stateMachine;

import controllers.Hannah;
import panels.PlayerRoles;

import javax.swing.*;

public class RoleState extends State{

    public RoleState(Hannah hannah) {
        super(hannah);
    }

    @Override
    public JPanel onContinue() {
        JPanel action = hannah.getState().onPrevious();
        hannah.changeState(new DayState(hannah));
        return action;
    }

    @Override
    public JPanel onPrevious() {
        hannah.changeState(new DayState(hannah));
        return new PlayerRoles();
    }

    @Override
    public String getCurrent() {
        return "Role";
    }
}
