package stateMachine;

import controllers.Hannah;
import panels.DayPanel;
import panels.NightPanel;
import panels.PlayerNames;
import panels.PlayerRoles;
import playerInfo.Player;

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
    public JTextArea onNorth() {
        return new PlayerNames().createPanel();
    }

    @Override
    public Box onSouth() {
        hannah.changeState(new RoleState(hannah));
        return new PlayerNames().doButton();
    }


    @Override
    public String getCurrent() {
        return "Name";
    }
}
