package stateMachine;

import panels.DayPanel;
import panels.PlayerNames;
import panels.PlayerRoles;

import javax.swing.*;

public class NightState extends State{

    public PlayerNames pnp;
    public PlayerRoles prp;
    public DayPanel dp;

    public NightState(Hannah hannah) {
        super(hannah);
    }

    @Override
    public JTextArea onName() {
        pnp = new PlayerNames(hannah);
        return pnp.createPanel();
    }

    @Override
    public JTextArea onRole() {
        prp = new PlayerRoles(hannah);
        return prp.createPanel();
    }

    @Override
    public JTextArea onDay() {
        dp = new DayPanel(hannah);
        hannah.changeState(new DayState(hannah));
        return dp.createPanel();
    }

    @Override
    public JTextArea onNight() {
        JTextArea action = hannah.getState().onNight();
        hannah.changeState(new DayState(hannah));
        return action;
    }

    @Override
    public String getCurrent() {
        return "Night";
    }
}
