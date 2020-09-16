package stateMachine;

import panels.DayPanel;
import panels.NightPanel;
import panels.PlayerNames;
import panels.PlayerRoles;

import javax.swing.*;

public class NameState extends State {

    public PlayerNames pnp;
    public PlayerRoles prp;
    public DayPanel dp;
    public NightPanel np;

    public NameState(Hannah hannah) {
        super(hannah);
    }

    @Override
    public JPanel onName() {
        JPanel action = hannah.getState().onName();
        hannah.changeState(new RoleState(hannah));
        return action;
    }

    @Override
    public JPanel onRole() {
        hannah.changeState(new RoleState(hannah));
        return new PlayerNames(hannah);
    }

    @Override
    public JPanel onDay() {
        hannah.changeState(new RoleState(hannah));
        return new PlayerNames(hannah);
    }

    @Override
    public JPanel onNight() {
        hannah.changeState(new RoleState(hannah));
        return new PlayerNames(hannah);
    }

    @Override
    public String getCurrent() {
        return "Name";
    }
}
