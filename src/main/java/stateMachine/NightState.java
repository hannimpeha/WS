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
    public JTextArea onNextTop() {
        return new NightPanel(hannah).createPanel();
    }

    @Override
    public JButton onNextBottom() {
        hannah.changeState(new DayState(hannah));
        return new NightPanel(hannah).doButton();
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
        return "Night";
    }
}
