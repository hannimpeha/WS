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
    public JTextArea onNextTop() {
        return new PlayerRoles(hannah).createPanel();
    }

    @Override
    public JButton onNextBottom() {
        return new PlayerRoles(hannah).doButton();
    }

    @Override
    public JTextArea onPreviousTop() {
        return null;
    }

    @Override
    public JButton onPreviousBottom() {
        return null;
    }


    @Override
    public String getCurrent() {
        return "Role";
    }
}
