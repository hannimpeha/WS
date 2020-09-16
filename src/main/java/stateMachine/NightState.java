package stateMachine;

import controllers.Hannah;
import panels.DayPanel;
import panels.NightPanel;
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
    public JPanel onNext() {
        hannah.changeState(new DayState(hannah));
        return new NightPanel(hannah);
    }

    @Override
    public String getCurrent() {
        return "Night";
    }
}
