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
    public JTextArea onName() {
        pnp = new PlayerNames(hannah);
        JTextArea action = pnp.createPanel();
        hannah.changeState(new RoleState(hannah));
        return action;
    }

    @Override
    public JTextArea onRole() {
        prp = new PlayerRoles(hannah);
        return prp.createPanel();
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
        return "Name";
    }
}
