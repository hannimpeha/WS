package stateMachine;

import panels.DayPanel;
import panels.NightPanel;
import panels.PlayerNames;
import panels.PlayerRoles;
import javax.swing.*;

public class DayState extends State {

    public PlayerNames pnp;
    public PlayerRoles prp;
    public DayPanel dp;
    public NightPanel np;

    public DayState(Hannah hannah) {
        super(hannah);
    }

    @Override
    public JPanel onName() {
        return null;
    }

    @Override
    public JPanel onRole() {
        return null;
    }

    @Override
    public JPanel onDay() {
        JPanel action = hannah.getState().onNight();
        hannah.changeState(new NightState(hannah));
        return action;
    }

    @Override
    public JPanel onNight() {
        hannah.changeState(new NightState(hannah));
        return new DayPanel(hannah);
    }

    @Override
    public String getCurrent() {
        return "Day";
    }

}
