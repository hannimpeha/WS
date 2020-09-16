package stateMachine;

import controllers.Hannah;
import panels.DayPanel;
import panels.NightPanel;
import panels.PlayerNames;
import panels.PlayerRoles;

import javax.swing.*;

public class RoleState extends State{

    public PlayerNames pnp;
    public PlayerRoles prp;
    public DayPanel dp;
    public NightPanel np;

    public RoleState(Hannah hannah) {
        super(hannah);
    }

    @Override
    public JPanel onName() {
        return null;
    }

    @Override
    public JPanel onRole() {
        JPanel action = hannah.getState().onDay();
        hannah.changeState(new DayState(hannah));
        return action;
    }

    @Override
    public JPanel onDay() {
        hannah.changeState(new DayState(hannah));
        return new PlayerRoles(hannah);
    }

    @Override
    public JPanel onNight() {
        return null;
    }

    @Override
    public String getCurrent() {
        return "Role";
    }
}
