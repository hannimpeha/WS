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
        JTextArea action = dp.createPanel();
        hannah.changeState(new NightState(hannah));
        return action;
    }

    @Override
    public JTextArea onNight() {
        np = new NightPanel(hannah);
        hannah.changeState(new NightState(hannah));
        return np.createPanel();
    }

    @Override
    public String getCurrent() {
        return "Day";
    }

}
