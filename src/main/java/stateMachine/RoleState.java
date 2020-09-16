package stateMachine;

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
    public JTextArea onName() {
        pnp = new PlayerNames(hannah);
        return pnp.createPanel();
    }

    @Override
    public JTextArea onRole() {
        prp = new PlayerRoles(hannah);
        JTextArea action = hannah.getState().onRole();
        hannah.changeState(new DayState(hannah));
        return action;
    }

    @Override
    public JTextArea onDay() {
        dp = new DayPanel(hannah);
        return dp.createPanel();
    }

    @Override
    public JTextArea onNight() {
        np = new NightPanel(hannah);
        return np.createPanel();
    }

    @Override
    public String getCurrent() {
        return "Role";
    }
}
