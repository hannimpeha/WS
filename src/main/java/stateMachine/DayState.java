package stateMachine;

import controllers.Hannah;
import panels.DayPanel;
import panels.NightPanel;
import panels.PlayerNames;
import panels.PlayerRoles;
import playerInfo.Player;

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
    public JTextArea onNorth() {
        hannah.changeState(new NightState(hannah));
        return new DayPanel().createPanel();
    }

    @Override
    public Box onSouth() {
        hannah.changeState(new NightState(hannah));
        return new DayPanel().doButton();
    }

    @Override
    public String getCurrent() {
        return "Day";
    }

}
