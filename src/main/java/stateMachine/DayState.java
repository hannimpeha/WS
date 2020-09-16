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
    public JTextArea onNextTop() {
        return new DayPanel(hannah).createPanel();
    }

    @Override
    public JButton onNextBottom() {
        hannah.changeState(new NightState(hannah));
        return new DayPanel(hannah).doButton();
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
        return "Day";
    }

}
